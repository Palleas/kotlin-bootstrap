#!/usr/bin/env bash

set +x

destination="generator/src/main/resources/bootstrap-icons.json"
github_output_file=$(mktemp)

curl -L -o "$github_output_file" https://api.github.com/repos/twbs/icons/git/trees/main\?recursive\=true
cat "$github_output_file" | jq -r '.tree | map(select(.path | startswith("icons/"))) | map(.path | split("/")[1])' > "$destination"