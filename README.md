Instructions for Windows:
- download Docker Desktop from here: https://www.docker.com/products/docker-desktop/?utm_source=chatgpt.com (Commercial use of Docker Desktop at a company of more than 250 employees OR more than $10 million in annual revenue requires a paid subscription (Pro, Team, or Business).)
- restart PC
- you need windows subsytem for linux (wsl --install if you don't have it yet or wsl --update if your version is not compatible with the Docker Desktop you just installed)
- Docker Desktop is running
- navigate to the location of this folder (FullStackTest) in a cmd
- execute "docker compose build" (This might take a few minutes)
- execute "docker compose up -d" (The '-d' allows to start the container in detached mode, so it runs outside of your cmd)
- and that's it - the app is running

Test Access:
- access webapp with http://localhost:3000
- backend json also separately accessible with http://localhost:5000/weatherforecast
