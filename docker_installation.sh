#!/bin/bash

echo "$(tput setaf 1)Update existing list of packages..."
echo "$(tput sgr0)"
sudo apt update

pid=$!
wait $pid
echo "$(tput setaf 1)Updating list of packages finished."
echo "$(tput sgr0)"

echo "$(tput setaf 1)install a few prerequisite packages which let apt use packages over HTTPS..."
echo "$(tput sgr0)"
sudo apt install apt-transport-https ca-certificates curl software-properties-common

pid=$!
wait $pid
echo "$(tput setaf 1)Installing prerequisite packages finished."

echo "$(tput setaf 1)Adding the GPG key for the official Docker repository to your system..."
echo "$(tput sgr0)"
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

pid=$!
wait $pid
echo "$(tput setaf 1)Adding the GPG key for the official Docker repository finished."

echo "$(tput setaf 1)Adding the Docker repository to APT sources..."
echo "$(tput sgr0)"
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"

pid=$!
wait $pid
echo "$(tput setaf 1)Adding the Docker repository to APT sources finished."

echo "$(tput setaf 1)Update the package database with the Docker packages from the newly added repo..."
echo "$(tput sgr0)"
sudo apt update

pid=$!
wait $pid
echo "$(tput setaf 1)Update the package database with the Docker packages finished."

echo "$(tput setaf 1)Installing from the Docker repo instead of the default Ubuntu repo..."
echo "$(tput sgr0)"
apt-cache policy docker-ce
pid1=$!
sudo apt install docker-ce
pid2=$!
wait $pid1
wait $pid2
echo "$(tput setaf 1)Installing from the Docker repo finished."


#Executing the Docker Command Without Sudo
echo "$(tput setaf 1)Configuring Docker to run without sudo..."
echo "$(tput sgr0)"
sudo usermod -aG docker ${USER}
pid=$!
wait $pid
echo "$(tput setaf 1)Configuring Docker to run without sudo finished."

read -p "Do you want the system to restart for docker configuration to take effect?(Y/n):" rebootConfirmed
if [[ "$rebootConfirmed" == "Y" || "$rebootConfirmed" == "y" ]]
then
    echo "$(tput setaf 1)Rebooting system to apply changes in 3 minutes..."
    echo "$(tput sgr0)"
    sudo shutdown -r +3
else
    echo ""
fi
