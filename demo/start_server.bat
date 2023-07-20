@echo off

@REM Starts a local web-server serving the contents of the `src/main/webapp`
@REM folder, which is the folder to where the web version is compiled.

cargo install basic-http-server

echo "open http://localhost:3002"

(cd src/main/webapp && basic-http-server --addr 127.0.0.1:3002 .)
