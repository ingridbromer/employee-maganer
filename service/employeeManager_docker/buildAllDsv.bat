docker-compose -f docker-compose-des.yml build
docker images dangling=true -q | foreach {docker rmi -f $_}
docker images
docker save $(docker images * -q) -o ./mydockerimagesDSV.tar
docker images * | sed "1d" | awk '{print $1,$2,$3}' > ./mydockerimagesDSV.list