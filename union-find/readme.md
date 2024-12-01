# Union-Find Algorithm

Connect Components: Maximal set of objects that are mutually connected.

## Quick-Find (Eager Approach)
### Data Structure
* **Integer Array `parent[]`:**
  * **Length:** `n` (number of elements)
  * **Interpretation:** Two elements `x` and `y` are considered connected if and only if `parent[x] == parent[y]`.

### Operations
1. **Initialize:**
* **Description:** Assigns each element's parent to itself, establishing each element as its own distinct component.
* **Time Complexity:** O(n)
2. **Find:**
* **Description:** Retrieves the root node of the given element `i`.
* **Time Complexity:** O(1)
3. **Connected:**
* **Description:** Determines whether two elements `x` and `y` are connected by comparing their root nodes.
* **Time Complexity:** O(1)
4. **Union:**
* **Description:** Merges the components containing elements `x` and `y` by updating all entries in the `parent[]` array that match `parent[x]` to `parent[y]`.
* **Time Complexity:** O(n)
5. **Count:**
* **Description:** Calculates the number of distinct connected components by identifying unique component identifiers within the `parent[]` array.
* **Time Complexity:** O(n)

### Cost Model
| **Operation** | **Time Complexity** | **Space Complexity** |
|---------------|---------------------|----------------------|
| Initialize    | O(n)                | O(n)                 |
| Union         | O(n)                | O(1)                 |
| Find          | O(1)                | O(1)                 |
| Connected     | O(1)                | O(1)                 |
| Count         | O(n)                | O(n)                 |

## Quick-Union (Lazy Approach)
### Data Structure
* **Integer Array `parent[]`:**
  * **Length:** `n` (number of elements)
  * **Interpretation:** `parent[i]` represents the parent of element `i`. The root of an element `i` is found by following the parent pointers until an element points to itself.

### Operations
1. **Initialize:**
* **Description:** Assigns each element's parent to itself, establishing each element as its own distinct component.
* **Time Complexity:** O(n)
2. **Find:**
* **Description:** Retrieves the root node of the given element `i` by traversing parent pointers until the root is reached.
* **Time Complexity:** O(n)
3. **Connected:**
* **Description:** Determines whether two elements `x` and `y` are connected by comparing their root nodes.
* **Time Complexity:** O(n)
4. **Union:**
* **Description:** Merges the components containing elements `x` and `y` by setting the parent of `x`'s root to the parent of `y`'s root.
* **Time Complexity:** O(n)
5. **Count:**
* **Description:** Calculates the number of distinct connected components by identifying unique roots within the `parent[]` array.
* **Time Complexity:** O(n)

### Cost Model
| **Operation** | **Time Complexity** | **Space Complexity** |
|---------------|---------------------|----------------------|
| Initialize    | O(n)                | O(n)                 |
| Union         | O(n)                | O(1)                 |
| Find          | O(n)                | O(1)                 |
| Connected     | O(n)                | O(1)                 |
| Count         | O(n)                | O(n)                 |

## Weighted Quick-Union
### Data Structure
* **Integer Array `parent[]`:**
  * **Length:** `n` (number of elements)
  * **Interpretation:** Same as Quick-Union.
* **Integer Array `size[]`:**
  * **Length:** `n`
  * **Interpretation:** `size[i]` stores the size (number of elements) of the tree rooted at `i`.

### Operations
1. **Initialize:**
* **Description:** Assigns each element's parent to itself and initializes the size of each tree to 1.
* **Time Complexity:** O(n)
2. **Find:**
* **Description:** Retrieves the root node of the given element `i` by traversing parent pointers until the root is reached.
* **Time Complexity:** O(log n)
3. **Connected:**
* **Description:** Determines whether two elements `x` and `y` are in the same component by comparing their root nodes.
* **Time Complexity:** O(log n)
4. **Union:**
* **Description:** Merges the components containing elements `x` and `y` by linking the root of the smaller tree to the root of the larger tree and updating the `size[]` array.
* **Time Complexity:** O(log n)
5. **Count:**
* **Description:** Maintains a count of distinct components, updated during union operations.
* **Time Complexity:** O(1)

### Cost Model
| **Operation** | **Time Complexity** | **Space Complexity** |
|---------------|---------------------|----------------------|
| Initialize    | O(n)                | O(n)                 |
| Union         | O(log n)            | O(1)                 |
| Find          | O(log n)            | O(1)                 |
| Connected     | O(log n)            | O(1)                 |
| Count         | O(1)                | O(1)                 |

## Weighted Quick-Union By Rank
### Data Structure
* **Integer Array `parent[]`:**
  * **Length:** `n` (number of elements)
  * **Interpretation:** Same as Quick-Union.
* **Integer Array `rank[]`:**
  * **Length:** `n`
  * **Interpretation:** `rank[i]` stores the rank (approximate height) of the tree rooted at `i`.

### Operations
1. **Initialize:**
* **Description:** Assigns each element's parent to itself and initializes the rank of each tree to 1.
* **Time Complexity:** O(n)
2. **Find:**
* **Description:** Retrieves the root node of the given element `i` by traversing parent pointers until the root is reached.
* **Time Complexity:** O(log n)
3. **Connected:**
* **Description:** Determines whether two elements `x` and `y` are in the same component by comparing their root nodes.
* **Time Complexity:** O(log n)
4. **Union:**
* **Description:** Merges the components containing elements `x` and `y` by linking the root of the lower-ranked tree to the root of the higher-ranked tree. If both trees have the same rank, link one to the other and increment the rank of the new root.
* **Time Complexity:** O(log n)
5. **Count:**
* **Description:** Maintains a count of distinct components, updated during union operations.
* **Time Complexity:** O(1)

### Cost Model
| **Operation** | **Time Complexity** | **Space Complexity** |
|---------------|---------------------|----------------------|
| Initialize    | O(n)                | O(n)                 |
| Union         | O(log n)            | O(1)                 |
| Find          | O(log n)            | O(1)                 |
| Connected     | O(log n)            | O(1)                 |
| Count         | O(1)                | O(1)                 |

## Quick-Union With Path Compression
### Data Structure
* **Integer Array `parent[]`:**
  * **Length:** `n` (number of elements)
  * **Interpretation:** Same as Quick-Union.

### Operations
1. **Initialize:**
* **Description:** Assigns each element's parent to itself.
* **Time Complexity:** O(n)
2. **Find:**
* **Description:** Retrieves the root node of the given element `i` while flattening the tree by making each examined node point directly to its grandparent.
* **Time Complexity:** O(α(n))
3. **Connected:**
* **Description:** Determines whether two elements `x` and `y` are in the same component by comparing their root nodes.
* **Time Complexity:** O(α(n))
4. **Union:**
* **Description:** Merges the components containing elements `x` and `y` by linking their roots.
* **Time Complexity:** O(α(n))
5. **Count:**
* **Description:** Maintains a count of distinct components, updated during union operations.
* **Time Complexity:** O(1)

### Cost Model
| **Operation** | **Time Complexity** | **Space Complexity** |
|---------------|---------------------|----------------------|
| Initialize    | O(n)                | O(n)                 |
| Union         | O(α(n))             | O(1)                 |
| Find          | O(α(n))             | O(1)                 |
| Connected     | O(α(n))             | O(1)                 |
| Count         | O(1)                | O(1)                 |

## Quick-Union With Path Compression Two Pass
### Data Structure
* **Integer Array `parent[]`:**
  * **Length:** `n` (number of elements)
  * **Interpretation:** Same as Quick-Union.

### Operations
1. **Initialize:**
* **Description:** Assigns each element's parent to itself.
* **Time Complexity:** O(n)
2. **Find:**
* **Description:** Retrieves the root node of the given element `i` using a two-pass approach: first finding the root, then setting the parent of each examined node to the root.
* **Time Complexity:** O(α(n))
3. **Connected:**
* **Description:** Determines whether two elements `x` and `y` are in the same component by comparing their root nodes.
* **Time Complexity:** O(α(n))
4. **Union:**
* **Description:** Merges the components containing elements `x` and `y` by linking their roots.
* **Time Complexity:** O(α(n))
5. **Count:**
* **Description:** Maintains a count of distinct components, updated during union operations.
* **Time Complexity:** O(1)

### Cost Model
| **Operation** | **Time Complexity** | **Space Complexity** |
|---------------|---------------------|----------------------|
| Initialize    | O(n)                | O(n)                 |
| Union         | O(α(n))             | O(1)                 |
| Find          | O(α(n))             | O(1)                 |
| Connected     | O(α(n))             | O(1)                 |
| Count         | O(1)                | O(1)                 |

## Weighted Quick-Union With Path Compression
### Data Structure
* **Integer Array `parent[]`:**
  * **Length:** `n` (number of elements)
  * **Interpretation:** Same as Weighted Quick-Union.
* **Integer Array `size[]`:**
  * **Length:** `n`
  * **Interpretation:** `size[i]` stores the size of the tree rooted at `i`.

### Operations
1. **Initialize:**
* **Description:** Assigns each element's parent to itself and initializes the size of each tree to 1.
* **Time Complexity:** O(n)
2. **Find:**
* **Description:** Retrieves the root node of the given element `i` while flattening the tree by making each examined node point directly to its grandparent.
* **Time Complexity:** O(α(n))
3. **Connected:**
* **Description:** Determines whether two elements `x` and `y` are in the same component by comparing their root nodes.
* **Time Complexity:** O(α(n))
4. **Union:**
* **Description:** Merges the components containing elements `x` and `y` by linking the root of the smaller tree to the root of the larger tree, updating the `size[]` array accordingly.
* **Time Complexity:** O(α(n))
5. **Count:**
* **Description:** Maintains a count of distinct components, updated during union operations.
* **Time Complexity:** O(1)

### Cost Model
| **Operation** | **Time Complexity** | **Space Complexity** |
|---------------|---------------------|----------------------|
| Initialize    | O(n)                | O(n)                 |
| Union         | O(α(n))             | O(1)                 |
| Find          | O(α(n))             | O(1)                 |
| Connected     | O(α(n))             | O(1)                 |
| Count         | O(1)                | O(1)                 |

## Summary of All Implementations
| **Algorithm**                              | **Initialize** | **Union** | **Find** | **Connected** | **Count** | **Space** |
|--------------------------------------------|----------------|-----------|----------|---------------|-----------|-----------|
| Quick-Find                                 | O(n)           | O(n)      | O(1)     | O(1)          | O(n)      | O(n)      |
| Quick-Union                                | O(n)           | O(n)      | O(n)     | O(n)          | O(n)      | O(n)      |
| Weighted Quick-Union                       | O(n)           | O(log n)  | O(log n) | O(log n)      | O(1)      | O(n)      |
| Weighted Quick-Union By Rank               | O(n)           | O(log n)  | O(log n) | O(log n)      | O(1)      | O(n)      |
| Quick-Union With Path Compression          | O(n)           | O(α(n))   | O(α(n))  | O(α(n))       | O(1)      | O(n)      |
| Quick-Union With Path Compression Two Pass | O(n)           | O(α(n))   | O(α(n))  | O(α(n))       | O(1)      | O(n)      |
| Weighted Quick-Union With Path Compression | O(n)           | O(α(n))   | O(α(n))  | O(α(n))       | O(1)      | O(n)      |

> **Note:**
> - `α(n)` is the inverse Ackermann function, which grows very slowly and is nearly constant for all practical purposes.
> - The space complexity for all implementations is primarily due to the `parent[]` array, with some implementations requiring additional arrays like `size[]` or `rank[]`.
