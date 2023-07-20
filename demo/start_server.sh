#!/usr/bin/env bash
set -eu

SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
echo "Script path: ${SCRIPT_PATH}"

# Starts a local gwt-server serving the contents of the `src/main/webapp`
# folder, which is the folder to where the gwt version is compiled.

cargo install basic-http-server

echo "open http://localhost:3002"

(cd ${SCRIPT_PATH}/src/main/webapp && basic-http-server --addr 127.0.0.1:3002 .)
