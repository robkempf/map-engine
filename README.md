# Map Engine  
  
### A high-performance graph street map library  
  
Complete documentation for this library is included here: doc/index.html  
  
When directing and guiding autonomous vehicles, there's need for a new kind of map,  
one that incorporates much more data, is blazing fast and runs anywhere without fail.  
Using a concise object model is a way to establish a solid framework for such a map.  
This model focuses on the data itself, rather than structures crafted elsewhere for  
a different purpose. The objective of this map architecture is to create a competitive  
market advantage for autonomous vehicles that use it.   
  
While choosing names for data, three objectives should guide us:  
1. Choose clear/simple names that help avoid misunderstandings that cause bugs.  
2. Choose names that make the code easier to read, by humans, our future selves.   
3. Keep the names general enough so expected changes won't make them obsolete.   
  
Where conflicts in naming data components arise, preference is given to terms  
used by actual transportation engineers, rather than terms from computer science  
or mathematics. Some names are modified to avoid conflicts with programming  
language key words. The best names are also valued for their brevity.   
  
Starting with the simplest objects first:  
  
"Location" is a point on the planet. It has three basic parts: latitude, longitude  
and elevation. Although GPS systems use the name altitude, we use elevation because  
that is the term used in geography and transportation science.   
  
"Node" is a location that links to other nodes and locations. It is a common term widely  
accepted in transportation and mathematics. The main risk with using node is confusion.  
Node is also used in many other ways in computer science, generative grammar, astronomy  
and physics. But here, brevity and acceptance seem to outweigh the risk of future confusion.  
  
"distance" is a better name than length. Here length might lead to later confusion because  
length might also refer to time or smaller measurements near the vehicle itself. There is  
less ambiguity in the word distance. Vehicles travel a distance, not a length.  
  
"direction" is used to define the course along which something moves. The word bearing  
is more often associated with the way a vehicle moves. This may lead to a dangerous future  
confusion. When describing a road it is more specific to refer to the course, not  
vehicle movement.  
  
"Turn" is used here to name the action taken by a vehicle. It is both brief and clear.  
  
"EndLane" describes one possible lane available for a vehicle to exit a link. End is  
part of this name to protect us from our future selves. It must remain clear that these  
lanes are at the end of the link construct.  
  
"Link" is a straight line with direction defining a short piece of a transportation network.  
It is a vector, with distance and direction, and is the fundamental construct of this  
overall object model. Maps are basically collections of nodes. Nodes both define and are  
defined by links. Other terms like segment are less clear and less specific. Most importantly,  
link is a term used by transportation engineers and makers of transportation maps.  
  
"Route" contains a contiguous series of links and defines a plan for getting from a  
point of "origin" to a "destination". Although Route is often pronounced differently (some  
say "r-out", others "root"), the word route is often associated with travel along a road  
and is the word used to describe routing problems like the VRP (vehicle routing problem).  
These three conventions - Route, origin and destination, appear to be the terms used by  
transportation engineers. Using them focuses the model on its external use rather than  
its underlying mathematics. No one boards an airliner to reach their drop-off or their  
point B. They arrive at an actual location, their destination. Likewise, although Uber  
may send a driver to a pickup location, what they really do is send the driver to the  
point of route origin. Furthermore, the object model is intended not just for taxi  
services, but also for applied autonomy of owner-directed vehicles. An owner may  
not need to be picked up, as their vehicle is already with them. But most importantly,  
route, origin and destination are the terms in active use by transportation engineers.  
  
"AreaMap" is simply a collection of nodes that define a transportation network. The node  
objects themselves all know how to link with one another. AreaMap also includes locations  
which are not necessarily nodes. The other locations can be points of interest segmented  
by type or class. An AreaMap defines a chosen area, effectively establishing boundaries of  
operation.  
  
In summary, these are the five (5) basic object classes use by the Map Engine:   
  
1. Location is any point on earth: latitude, longitude and elevation.  
  
2. Node is a Location on a road with a set of links that begin or end there.  
  
3. Link connects only two Nodes along a road in only one direction.  
  
4. Route describes how to get from origin to destination.  
  
5. AreaMap contains all roads and notable locations in an area.  