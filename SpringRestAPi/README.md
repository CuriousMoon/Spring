
# Course API using Spring

Created few apis to perform actions on the list of Courses present in database.




## Description

+ ### Home Page: "/home"
    - @Get method
    - This endpoint don't have and request body. In response  this returns welcome message.

+ ### List of Courses: "/courses"
    - @Get method
    - This endpoint don't have and request body. In response it return list of courses.

+ ### Detail of a Course: "/courses/{courseId}"
    - @Get method
    - This endpoint don't have and request body. In response this  endpoint will return id, course name and course description of requested course id.

+ ### Add a Course: "/courses"
    - @Post method
    - This endpoint is used to add a new course in database. In request body id, course name and description of course is send in json format.

+ ### Update Course: "/courses"
    - @Put method
    - This endpoint is used to update any exsisting course. In request body send id, (updated) course name and (updated) course description. In response it returns the updated course. In response this return the appropriate response code.

+ ### Delete Course: "/courses/{courseId}"
    - @Delete method
    - This endpoint is used to delete course with given course id


## Tech Stack

+ Java
+ Spring
+ JPA Repository
+ Spring JDBC
+ Postman

