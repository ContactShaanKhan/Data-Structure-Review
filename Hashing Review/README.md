# Hashing Notes:

#### In hashing there are two main concepts:
- Collision Resistance: We want to resist collisions (We can achieve this with well designed hash functions)
- Collision Resolution: If/when we collide, how are we resolving?  This can be achieved many way:
  - Linear Probing (Linear Hashing)
  - Quadratic Probing (Quadratic Hashing)
  - Double Hashing
  - Chain Hashing      


`Linear hashing`, `Quadratic hashing`, and `Double hashing` are all extremely similar.  
You will notice in the code that the only difference between these three is the getInsertionIndex() method.    
#### Here is how they differ with the probe sequence:
- Double Hashing: `index = (h1(key) + (i * h2(key))) % maxSize`
- Linear Hashing (Linear Probe): `index = (h1(key) + i) % maxSize`
- Quadratic Hashing (Quadratic Probe): `index = (h1(key) + (i * i)) % maxSize` 

`Chain hashing` is the most different, there is no i value with getInsertionIndex() since it only picks an index once and then appends it the the chain at that index.    

#### Important Notes:
- No duplicated keys!
- In a hash Tabe everything is stored as a (key, value) pair
- The key is used for finding the element
