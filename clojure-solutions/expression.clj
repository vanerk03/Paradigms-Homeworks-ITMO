(defn factory [f] (fn [a, b] (fn [x] (f (a x) (b x)))))

(def safe-division (fn [a b] (/ (double a) (double b))))

(def add (factory +))
(def multiply (factory *))
(def subtract (factory -))
(def divide (factory safe-division))

(defn ln [a] (fn [x] (Math/log (a x))))
(defn exp [a] (fn [x] (Math/exp (a x))))

(defn constant [a]
  (fn [x] a))

(defn variable [a]
  (fn [x] (x a)))

(defn negate [a] (fn [x] (- (a x))))

(def oper {'negate negate
           '+ add
           '- subtract
           '* multiply
           '/ divide
           'exp exp
           'ln ln})

(defn parses [x] (cond
                   (number? x) (constant x)
                   (symbol? x) (variable (name x))
                   :else (apply (get oper (first x)) (mapv parses (rest x)))))

(defn parseFunction [x] (parses (read-string x)))


"-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-Homework-11-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^"


(defn proto-get
  ([obj key] (proto-get obj key nil))
  ([obj key default]
   (cond
     (contains? obj key) (obj key)
     (contains? obj :prototype) (proto-get (obj :prototype) key default)
     :else default)))


(defn proto-call
  "Calls object method respecting the prototype chain"
  [this key & args]
  (apply (proto-get this key) this args))


(defn field [key]
  (fn
    ([this] (proto-get this key))
    ([this def] (proto-get this key def))))


(defn method
  "Creates method"
  [key] (fn [this & args]
          (apply proto-call this key args)))


(def evaluate (method :eval))
(def toString (method :toString))
(def diff (method :diff))
(def toStringSuffix (method :toStringSuffix))

(def _a (field :a))
(def _b (field :b))
(def _sign (field :sign))
(def _f (field :f))


(def binary-proto {:toString
                   (fn [this] (str "(" (_sign this) " " (toString (_a this)) " " (toString (_b this)) ")"))
                   :toStringSuffix
                   (fn [this] (str "(" (toStringSuffix (_a this)) " " (toStringSuffix (_b this)) " " (_sign this) ")"))
                   :eval
                   (fn [this mp]
                     ((_f this) (evaluate (_a this) mp) (evaluate (_b this) mp)))})


(defn proto-constructor [f sign diff-rule base-proto] (assoc base-proto :f f :sign sign :diff diff-rule))

(defn constructor [proto] (fn [a b] {:a a :b b :prototype proto}))

(defn unary-constructor [proto] (fn [a] {:a a :prototype proto}))

(declare Add)
(declare Multiply)
(declare Divide)
(declare Subtract)
(declare Constant)
(declare Negate)
(declare Exp)
(declare Ln)

(defn square [this] (Multiply this this))

(def product-rule (fn [a b var] (Add (Multiply (diff a var) b) (Multiply a (diff b var)))))
(def quotient-rule (fn [a b var] (Divide (Subtract (Multiply (diff a var) b) (Multiply a (diff b var))) (square b))))

(def diff-rule-add (fn [this var] (Add (diff (_a this) var) (diff (_b this) var))))
(def diff-rule-sub (fn [this var] (Subtract (diff (_a this) var) (diff (_b this) var))))
(def diff-rule-mul (fn [this var] (product-rule (_a this) (_b this) var)))
(def diff-rule-div (fn [this var] (quotient-rule (_a this) (_b this) var)))

(def Add (constructor (proto-constructor + "+" diff-rule-add binary-proto)))
(def Multiply (constructor (proto-constructor * "*" diff-rule-mul binary-proto)))
(def Subtract (constructor (proto-constructor - "-" diff-rule-sub binary-proto)))
(def Divide (constructor (proto-constructor safe-division "/" diff-rule-div binary-proto)))


(def const-proto {:diff (fn [this var] (Constant 0))
                  :eval (fn [this mp] (_a this))
                  :toString (fn [this] (str (_a this)))
                  :toStringSuffix (fn [this] (str (_a this)))
                  })

(def Constant (unary-constructor const-proto))

(def ONE (Constant 1))
(def ZERO (Constant 0))

(defn first-char [s] (str (Character/toLowerCase (get s 0))))

(def var-proto {:diff (fn [this var]
                        (cond
                          (= (first-char (_a this)) var) ONE
                          :else ZERO))
                :toString (fn [this] (str (_a this)))
                :toStringSuffix (fn [this] (str (_a this)))
                :eval (fn [this mp] (get mp (first-char (_a this))))})

(def negate-proto {:diff (fn [this var] (Negate (diff (_a this) var)))
                   :toString (fn [this] (str "(negate " (toString (_a this)) ")"))
                   :eval (fn [this mp] (- (evaluate (_a this) mp)))
                   :toStringSuffix (fn [this] (str "(" (toStringSuffix (_a this)) " negate)"))
                   })

(def exp-proto {:diff (fn [this var] (Multiply (diff (_a this) var) this))
                :toString (fn [this] (str "(exp " (toString (_a this)) ")"))
                :eval (fn [this mp] (Math/exp (evaluate (_a this) mp)))})


(def ln-proto {:diff (fn [this var] (Multiply (Divide ONE (_a this)) (diff (_a this) var)))
               :toString (fn [this] (str "(ln " (toString (_a this)) ")"))
               :eval (fn [this mp] (Math/log (evaluate (_a this) mp)))})


(def Variable (unary-constructor var-proto))
(def Negate (unary-constructor negate-proto))

(def Ln (unary-constructor ln-proto))
(def Exp (unary-constructor exp-proto))

(def oper-obj {'negate Negate
               '+ Add
               '- Subtract
               '* Multiply
               '/ Divide
               'exp Exp
               'ln Ln})

(defn parses1 [x] (cond
                    (number? x) (Constant x)
                    (symbol? x) (Variable (name x))
                    :else (apply (get oper-obj (first x)) (mapv parses1 (rest x)))))

(defn parseObject [x] (parses1 (read-string x)))

"...............................................Homework...12...................................................."

(load-file "parser.clj")

(def str-obj {"negate" Negate
              "+" Add
              "-" Subtract
              "*" Multiply
              "/" Divide})

(def arity  {"negate" 1
             "+" 2
             "-" 2
             "*" 2
             "/" 2})


(defn string-to-vec [s] (vec (.split (.trim  s) "\\(|\\)|\\s")))
(defn pop-left [v] (vec (drop 1 v)))

(defn parse2 [v prev]
  (if (empty? v)
    (first prev)
    (let [elem (first v) v (pop-left v)]
      (cond
        (empty? elem) (recur v prev)
        (contains? str-obj elem) (let [func (str-obj elem) ar (arity elem) a (peek prev) prev (pop prev)]
                                   (if (= ar 1)
                                     (recur v (conj prev (func a)))
                                     (let [b (peek prev) prev (pop prev)]
                                       (recur v (conj prev (func b a))))))

        (number? (read-string elem)) (recur v (conj prev (Constant (read-string elem))))
        :else (recur v (conj prev (Variable elem)))))))

(defn parseObjectSuffix [x]
  (parse2 (string-to-vec x) []))

;; (print (evaluate (Variable "Xanax") {"x" 0}))