#CQRS

Command Query Responsibility Segregation (CQRS) originates from the Command Query Separation (CQS) Principle
- CQRS extend CQS to the architectural level
- Split a unified domain model into two: for commands and for queries

CQRS benefit
- better scalability
- better performance
- simpler code
  CQRS is SPR applied at the architectural level.

CQRS is one model for write and separate model for read.

DDD and CQRS help tackle code complexity

Anemic domain model vs Rich one

PB with CRUD-based interface
 - uncontrolled growth of complexity: too many features in a single method and increase in number of bugs
 - expert don't speak in CRUD terms hence the implementation might be different in terms of interpretation 
 - lack of ubiquitous language. bring maintainability issues
 - damaging user experience: hard to build a proper mental model. too many features on a single window
 - cyclomatic complexity is elevated
 
 CRUD-based thinking: fitting all operation into CRUD terminology. CRUD-based interface is the result of CRUD-base thinking. 
 Interface means both UI and API
 Avoid CRUD-base thinking
 Create & Delete should be Register & Unregister
 Avoid DTOs with 'holes' in them. 
 
 Task-based interface
 - identify each task the user can accomplish within an application
  - intuitive UI: each window does one thing
  - restore the single responsibility principle
  - improve user experience
  - code base simplification
  
 Task-based is not pre-requisite for CQRS.
 you can have one with or without the other.

A command is a serializable method call

All message in an app can be divided in three categories: commands, queries, events
the commands ask the app to do something. it is imperative tense. Sever can reject. Should use ubiquitous language
the queries ask the app about something. Start with <<Get>>
the event inform external application. It is always in the past tense. Sever can't reject.

All messages are part of the core domain (the central layer) in an Onion architecture. They should be isolated from 
the outside world.

#Commands & queries in the Onion architecture
Commands, events and queries should reside in the core domain layer
Commands is the push model: trigger from external system
Event is pull model: trigger by the building application

#Commands vs Queries in CQS an CQRS taxonomies
-CQS: command is a method that mutate states
-CQRS: command represent what you can do with an application

#Commands vs DTOs
Using commands in place of DTOs hinder your ability to refactor
commands explicitly state what an application can do
DTOs help  achieve backward compatibility with data contract.
If you don't need backward compatibility in your application, then it is fine not to use DTOs. 
For example if you have a single client, if you can deploy client and API simultaneously.

#Decorator
it is a class or method that modifies the behavior of an existing class or method
without changing its public interface. 
Decorator introduce cross-cutting content and avoid code duplication.
We  can separate technical concerns into decorator and functional concerns in handlers


