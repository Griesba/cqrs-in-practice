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


#Separation of the domain model
the fact  that we use same model for read and write leads to domain model over-complication and bad query performance.
Are we going to have two domains model? no! we are going to take the domain model out of the read side.
We will introduce a separate database for queries in order to scale reads indefinitely, adjust the read database for the need of the query model.
Read model is a thin wrapper on top of the database. We can use database-specific features to optimize the performance. 

Example of separations at the data level:
- usage of index view
- database replication
- elasticSearch

#Design database for reads
- design is denormalized and adjusted to the need of read model. Only on table for student with associated courses
- minimize the number of joins and the amount of post-processing
We will end up with a 3rd normal relation forms for command and 1rd normal (denormalized) relation for queries

#projection
projections they are database synchronizations between commands and queries.
When we separate database, we need a synchronization between command database and queries databases

state-driven projection
- synch projection : index views. Latency increase with complexity of queries (don't scale well)
- asynch: database replication
event-driven projection
- projection subscribe to events for updates
- scale very well
- can use message bus
- cannot rebuild the read database from scratch or in case of error

#Eventual consistency
 - a consistency model which guarantees that, if no new updates are made to a given item,
   eventually all accesses to that item will return the last updated value. 
 - train user not to expect data to be immediately consistent
 - the real world is eventual consistent (not simultaneous)
 - is problematics when the cost of making decision based on stale data is high
 - use versioning to prevent modification on stale data: if user try to update data v2 when v1 is under synchronisation an error should be thrown

#scalability vs performance
scalability takes place when the performance of one server is not enough.
Scalability: utilizing the resource of more than one server. 
Processing of queries and commands is asymmetric. There are many more queries than command and events.


#CQRS and Event sourcing
- CQRS is not a transition to event sourcing
- CQRS can stand alone without event sourcing, but you need CQRS to implement event sourcing
- the bar for event sourcing is much higher than it is for CQRS
- event sourcing system want to keep track of all event that lead to a particular state( a trail of the financial transactions)
