# TODO

- Create search form, and populate it with data which is filtered automatically as you type
    - use tickboxes to filter
- populate dropmenu for searching at start time, and as search box is being inputted
- Show links, can click link, and pop will show data,
    - show preview when clicked
- ~~Split front end and back end into separate packages~~
    - This has been split to js and resources
- Get rid of <scripts> in html
    - Figure out how to use
        - webpack
        - package.json
- organise vuejs code into sepearate files
   - By components


NOTES:

- Now if changing js have to run mvn clean install

# Run

1. run `mvn clean install -DskipTests`
2. run main in `springbootvuedemo/SpringBootVueDemoApplication.java`
3. go to `localhost:8080/` for front end
4. go to `localhost:8080/api` for api

Alternative
1. Go into project`cd spring-boot-vue-demo`
2. run `mvn clean install`
3. `java -jar target/spring-boot-vue-demo-0.0.1-SNAPSHOT.jar`
