;; MOVES SHOULD BE PASSED AS ONE INTEGER

;; returns lst[i][j]
(defn get-elem [i j lst] (nth (nth lst i) j))

;; board height and board width respectively
(def board-h 5)
(def board-w 5)

;; generates vector of vectors
(defn vec2d
  [x y]
  (vec (repeat y (vec (repeat x 0)))))

(def board (vec2d board-h board-w))

;; returns new vector of vectors with s[i][j] assigned to value
(defn change [i j value lst] (assoc lst i (assoc (nth lst i) j value)))

;; reads move from command line
(defn get-move [] (
     read-string (read-line)                          
))

;; cnt should be set to zero, as it counts number of equal elements in a row
;; i-shift and j-shift are shifts we make, not to make 3 different functions for different directions
(defn check-board [i j cnt player i-shift j-shift lst] (if (or (= i board-h) (= j board-w) (= i -1) (= j -1)) false
                                                           (if (== (get-elem i j lst) player)
                                                             (let [i (+ i i-shift) j (+ j j-shift) cnt (+ 1 cnt)]
                                                               (if (== cnt 4) true
                                                                   (check-board i j cnt player i-shift j-shift lst)))
                                                             (let [i (+ i i-shift) j (+ j j-shift) cnt 0] (check-board i j cnt player i-shift j-shift lst)))))

;; makes move on the row j and returns new board
;; we assume that the move is possible
(defn make-move [board player i j] (if (or (== (+ 1 i) board-h) (not= 0 (get-elem (+ i 1) j board)))
                                     (change i j player board)
                                     (make-move board player (+ i 1) j)))


;; loops over 0 to board-w inclusive, checks if the game is over for fixed player and moving direction
(defn for-loop [cur player i-sh j-sh board]
  (if (or (check-board cur 0 0 player i-sh j-sh board) (check-board 0 cur 0 player i-sh j-sh board)) true
      (if (== board-w cur) false
          (for-loop (+ cur 1) player i-sh j-sh board))))

;; checks all directions in which 4 sequential chips might be found
(defn is-over [board] (or (for-loop 0 1 1 0 board)
                          (for-loop 0 1 1 -1 board)
                          (for-loop 0 1 1 1 board)
                          (for-loop 0 1 0 1 board)

                          (for-loop 0 2 1 0 board)
                          (for-loop 0 2 1 1 board)
                          (for-loop 0 2 1 -1 board)
                          (for-loop 0 2 0 1 board)))

;; game implementation (doesn't support players yet)
(defn game [board turn move-cnt]
  (if (and (== move-cnt (* board-h board-w)) (not (is-over board))) "draw"
      (if (is-over board) (str "Player: " turn " won on move: " move-cnt)
          (let [turn (+ 1 (mod turn 2))
                move-cnt (+ 1 move-cnt)
                board (make-move board turn 0 (get-move))] 
            (println board)
            (game board turn move-cnt)))))

;; example of correct usage of make-move
(println (make-move (make-move board 1 0 4) 1 0 4))
(println (is-over [[0 2 1 0 0] [0 2 1 0 0] [0 2 1 0 0] [0 2 1 0 0] [0 2 1 0 0]]))
;; game starts and waits for your move there is a bug (((
(println (game board 1 0))

;; (println (game board 1 1))
;; some tests for is-over function are provided (ones denote moves of a first player, here we assume his opponents did not show up)
(def win1 [[1 0 0 0 0]
           [1 0 0 0 0]
           [1 0 0 0 0]
           [1 0 0 0 0]
           [0 0 0 0 0]])

(def win2 [[1 0 0 0 0]
           [0 1 0 0 0]
           [0 0 1 0 0]
           [0 0 0 1 0]
           [0 0 0 0 0]])


(def win3 [[0 0 0 0 0]
           [1 1 1 1 0]
           [0 0 0 0 0]
           [0 0 0 0 0]
           [0 0 0 0 0]])


(def unclear1 [[0 0 0 0 0]
               [0 1 1 1 0]
               [0 0 0 0 0]
               [0 0 0 0 0]
               [0 0 0 0 0]])

(def unclear2 [[0 0 0 0 0]
               [0 0 1 0 0]
               [0 1 0 0 0]
               [1 0 0 0 0]
               [0 0 0 0 0]])

(defn local-tests []
  (println (is-over win1))
  (println (is-over win2))
  (println (is-over win3))
  (println (is-over unclear1))
  (println (is-over unclear2)))

(local-tests)