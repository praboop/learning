package app


import java.text.SimpleDateFormat
import java.util.Date

import scala.collection.mutable.ListBuffer
import scala.util.Random

class CpuLoader {


  var loadThread:ListBuffer[Thread] = ListBuffer()
  @volatile var isBusyScheduleOver = false
  var busyDuration:Int = 0
  var idleDuration:Int = 0
  var stopFlag: Boolean =  true
  val r = new Random()
  val sdf: SimpleDateFormat = new SimpleDateFormat("HH:MM:ss.SSS")

  private def info(msg: String): Unit = {
    println(sdf.format(new Date) + "  " + msg)
  }

  private def busySleepCycle() {

    while (!stopFlag) {

      val idleThread = new Thread {

        val busyThread = new Thread {
          override def run {
            info("BUSY THREAD STARTED. Total threads " + loadThread.size)
            try {
              val startTime = System.currentTimeMillis()
              isBusyScheduleOver = false
              while (!stopFlag && !isBusyScheduleOver) {
                for (i <- r.nextInt(10) to r.nextInt(100) if !isBusyScheduleOver) {
                  r.nextInt(1000) * r.nextInt(3000)
                  //Thread.sleep(3)
                }

              }
            } catch {
              case _: Throwable => info("BUSY THREAD FORCED EXIT")
            }
            info("BUSY THREAD EXIT")
          }
        }

        override def run: Unit = {
          try {
            busyThread.setPriority(1)
            busyThread.start()
            busyThread.join(busyDuration)
            info("IDLE THREAD - MARKING BUSY THREAD SHOULD TERMINATE")
            isBusyScheduleOver = true
            while (busyThread.isAlive) {
              busyThread.interrupt()
              info("IDLE THREAD START. Is busyThread Running? " + busyThread.isAlive)
              Thread.sleep(10)
            }
          } catch {
            case _: Throwable => info("BUSY THREAD FORCED EXIT 2")
          }

          info("IDLE THREAD START1. Is busyThread Running? " + busyThread.isAlive)
          Thread.sleep(idleDuration)
          info("IDLE THREAD END")
        }
      }
      try {
        idleThread.start()
        idleThread.join()
      } catch {
        case _: Throwable => info("IDLE THREAD FORCED EXIT")
      }
    }

  }

  def start(): Unit = {
    stopFlag = false

//    if (loadThread.nonEmpty)
//      return

    var newThread =  new Thread {
      override def run: Unit = {
        busySleepCycle()
      }
    }
    loadThread += newThread
    newThread.start()
    info("Added a Thread. Active Threads: " + loadThread.size)
  }

  def stop(): Unit = {
    stopFlag = true

//    if (!loadThread.nonEmpty)
//      return

    if (loadThread.isEmpty)
      return

    try {  loadThread.head.interrupt(); loadThread.drop(1) } catch { case _: Throwable => None }
    info("Dropped a Thread. Active Threads: " + loadThread.size)
  }

}
