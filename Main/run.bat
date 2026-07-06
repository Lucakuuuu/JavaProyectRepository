@echo off
cd /d "%~dp0"
if not exist bin mkdir bin
powershell -NoProfile -Command "Set-Location '%~dp0'; javac -d bin (Get-ChildItem -Path .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName })"
java --module-path bin -m Main/Launcher.AppLauncher
