docker-compose -f docker-compose-prd.yml build
docker images dangling=true -q | foreach {docker rmi -f $_}
docker images
docker save $(docker images * -q) -o ./mydockerimagesPRD.tar
docker images * | sed "1d" | awk '{print $1,$2,$3}' > ./mydockerimagesPRD.list