@echo off
:: Set timestamp
for /f "tokens=1-4 delims=/ " %%a in ("%date%") do (
   set month=%%a
   set day=%%b
   set year=%%c
)
for /f "tokens=1-2 delims=: " %%a in ("%time%") do (
   set hour=%%a
   set minute=%%b
)

:: Remove any spaces (needed for 12-hour format)
set hour=%hour: =0%

:: Combine for folder name
set timestamp=%year%-%month%-%day%_%hour%%minute%
set folder=manual-run-%timestamp%

echo.
echo Running Maven Tests...
mvn clean test

echo.
echo Generating Allure Report...
allure generate target/allure-results --clean -o target/reports/%folder%

echo.
echo Report saved to: target/reports/%folder%
start target/reports/%folder%\index.html
