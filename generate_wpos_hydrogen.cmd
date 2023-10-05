@echo off

java -jar modules\openapi-generator-cli\target\openapi-generator-cli.jar generate --skip-validate-spec --global-property debugModels,debugOperations,debugSupportingFiles %1 -c bin\configs\delphi-whizaxe-wpos-hydrogen.yaml > wpos_hydrogen.log
