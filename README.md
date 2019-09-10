# Lowest Common Ancestor

## Problem
Given a binary tree and two nodes, find the Lowest Common Ancestor (LCA) of both nodes.

## Solution
Build a REST server that receives a Tree and two nodes, then return the LCA.   

- Build the model of Tree and Nodes.
- Build a persistence model scalable to the needs of the Microservice.
- Build the controller model, a health controller and the REST Tree controller.

## How to run
This is a Maven project using spring-boot. It is required to have installed Java 8 JDK to compile and run the project. Use these instructions to run the server

* Linux: ```./mvnw clean compile spring-boot:run```
* Windows: ```.\mvnw clean compile spring-boot:run```

## How to use
To check the health of this MS and verify it started an endpoint at
`http://localhost:8080/health` 
with HTTP Method GET.
If the MS started it should return an empty 200 OK

The main controller is located at
`http://localhost:8080/trees`
This is going to be referred as the "Tree endpoint"
It offers two methods:

- Save a Tree: To save a Tree you need to do a HTTP POST to the Tree endpoint a petition with a JSON body of the Tree.
  - Node:
``
{
  "value": "integerValue",
  "nodeOne": "aNodeMayBeNull",
  "nodeTwo": "aNodeMayBeNull"
}
``
  - Tree:
``
{
  "root": "aNode"
}
``
  - Example of Tree with Nodes:
``
{
  "root": {
    "value": 3,
    "nodeOne": {
      "value": 1,
      "nodeOne": {
        "value": 4
      },
      "nodeTwo": {
        "value": 7,
        "nodeOne": {
          "value": 1,
          "nodeOne": {
            "value": 8
          },
          "nodeTwo": {
            "value": 9
          }
        }
      }
    },
    "nodeTwo": {
      "value": 2,
      "nodeOne": {
        "value": 5
      },
      "nodeTwo": {
        "value": 6
      }
    }
  }
}
``

After saving the Tree the server will return the same Tree with the given ID (This will be used to calculate the LCA).

- Calculate the LCA of the Tree: Do an HTTP Get petition to 
``{{ Tree endpoint }}/{treeId}/lowest-common-ancestor?p={integerValue}&q={integerValue}``
This will return an integer number, the value of the LCA Node.

Considerations
1. If the given Tree id does not exist it will return 404 not found.
2. If one or both given nodes does not exist it will return 404 not found.
