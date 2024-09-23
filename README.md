# contact-app
This is a developer challenge for UX studio. For demonstration purposes only!

## contacts_frontend
Vue 3 application.\
After clone, install and run at the main directory (.../contacts_frontend)\
`'npm install'` \
after\
`'npm run dev'`

The application will be available at:\
`'http://localhost:5173/'`

## contacts_server
Spring boot REST API server with Maven. Use your favourite devTools to open.\
First of all, at: \
contact-app\contacts_server\src\main\resources\application.properties 

Change this line:\
`'spring.datasource.url=/database/contacts.db'`

To this line:\
`'spring.datasource.url=jdbc:sqlite:[your system]/contact-app/database/contacts.db'`

After **Clean and Build** the project with **Maven**.

The API will be available at:\
`'http://localhost:8080/'`

## Comment
If you cannot build the server, try run directly the ContactsServerApplication.java at:\
`'contact-app/contacts_server/src/main/java/com/example/contacts_server/'`

If you have any questions, feel free to ask.

