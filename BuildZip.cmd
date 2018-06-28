@echo off
For /f "tokens=1-3 delims=/ " %%a in ('date /t') do (set mydate=%%c-%%b-%%a)
For /f "tokens=1-2 delims=/:" %%a in ('time /t') do (set mytime=%%a%%b)
echo %mydate%_%mytime%
git archive  --format=zip --output=G:\REPOSITORY\HackersProject%mydate%_%mytime%.zip master