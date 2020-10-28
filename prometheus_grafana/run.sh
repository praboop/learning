docker build sampleapp -t sampleapp:1.0

echo ""

while true; do
    read -p "Do you wish to deploy?" yn
    case $yn in
        [Yy]* ) docker stack rm teststack; docker stack deploy --compose-file=docker-compose.yml teststack; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

