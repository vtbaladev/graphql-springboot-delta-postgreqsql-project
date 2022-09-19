# graphql-springboot-delta-psql
The example exposes a GraphQL API 
1)Allows the user to store and query `Link` objects containing a url and a short description inmemory.
2)Connect to postgresql devdatabase. nucleusreports_dev and CRUD operations on public.accounts table
3)Connect to delta lake dev cluster and does operations on Delta lake example table poc.section

## Running the Example
1. Start the example by running the following Gradle command:

        $ ./gradlew bootRun 

2. Once the application has started, interact with the API at [http://localhost:8080/graphiql](http://localhost:8080/graphiql).

3. To list all `Link` objects, execute the following graphql query in the [GraphiQL interface](http://localhost:8080/graphiql):

        {
          allLinks {
            url
            description
          }
        }

   You should see the following response:

        {
          "data": {
            "allLinks": [
              {
                "url": "https://www.netifi.com",
                "description": "Autonomous microservices platform"
              },
              {
                "url": "http://howtographql.com",
                "description": "Your favorite GraphQL page"
              },
              {
                "url": "http://graphql.org/learn/",
                "description": "The official docks"
              }
            ]
          }
        }

4. Next, add a new `Link` by executing the following graphql mutation in the [GraphiQL interface](http://localhost:8080/graphiql):

        mutation linkCreate {
          linkCreate(
            url: "https://www.google.com",
            description: "Google"
          ) {
            url
            description
          }
        }

   If the mutation was successful you should see the following response:

        {
          "data": {
            "linkCreate": {
              "url": "https://www.google.com",
              "description": "Google"
            }
          }
        }

5. Finally, execute the `allLinks` query again by running the following graphql query in the [GraphiQL interface](http://localhost:8080/graphiql):

        {
          allLinks {
            url
            description
          }
        }

   You should see the link you added now being returned in the response:

        {
          "data": {
            "allLinks": [
              {
                "url": "https://www.netifi.com",
                "description": "Autonomous microservices platform"
              },
              {
                "url": "http://howtographql.com",
                "description": "Your favorite GraphQL page"
              },
              {
                "url": "http://graphql.org/learn/",
                "description": "The official docks"
              },
              {
                "url": "https://www.google.com",
                "description": "Google"
              }
            ]
          }
        }

Postgreqsql Connection

1) Query operation
{
AccountByIdQuery(id:4){
id
email
section
coursexid
}
}

query getAccountByIdQuery{
AccountByIdQuery(id:4){
id
email
section
coursexid
}
}

query getAllAccountsQuery{
AllAccounts{
id
email
section
coursexid
}
}

mutation insertAccountsMutation{
insertAccountsMutation(id: 5,
name: "peter",
coursexid: "xidElectronics",
email: "peter@mail.com",
section: "section5"){
id
username
coursexid
email
section
}
}


mutation deleteAccounts{
deleteAccounts(id: 6)
}

VALIDATION:

POSTGRESQL TABLE

select * from public.accounts

DELTA LAKE QUERY & MUTATION

query getAllSections{
AllSections{
sectionid
sectionname
sectionxid
coursexid
}
}

query getSectionById{
SectionById(id:3){
sectionid
sectionxid
sectionname
coursexid
}
}


mutation insertSectionMutation{
insertSectionMutation(sectionid: 11,
sectionName: "section10",
sectionXID: "section10xid",
courseXID: "xidGeography"
){
sectionid
sectionname
sectionxid
coursexid
}
}

mutation deleteSectionMutation{
deleteSectionMutation(sectionid: 10
)
}


VALIDATION:

DELTA TABLE:

%sql select * from poc.section



Good Links:
https://confluence.mheducation.com/pages/viewpage.action?pageId=399929079 
Graphql Voyager - an-interactive-graphql-schema-explorer https://apis.guru/graphql-voyager/
GraphQl all related links:
https://github.com/chentsulin/awesome-graphql

