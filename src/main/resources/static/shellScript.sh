sudo cp target/DemoSpringBootProject-0.0.1-SNAPSHOT.jar /Users/vamshidhar/dev/DemoSpringBootProject-0.0.1-SNAPSHOT.jar
cd /Users/vamshidhar/dev
bash cf login -a https://api.local.pcfdev.io --skip-ssl-validation -u user -p pass -o pcfdev-org
bash cf push localhost -p DemoSpringBootProject-0.0.1-SNAPSHOT.jar
