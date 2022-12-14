divby(N, K) :-
	R is N mod K,
	R = 0.

isPrime(N, K) :-
	KSquare is K * K,
	K1 is K + 1,
	((KSquare > N) ;
	((not divby(N, K), isPrime(N, K1)))).

prime(N) :- 
    prime_table(N), !.

prime(N) :- 
    N > 1, 
    isPrime(N, 2), 
    assert(prime_table(N)).
    
composite(N) :- N > 1, not prime(N).

prime_divisors(N, Divisors) :-
	list(Divisors), 
	!, 
	num(N, Divisors).

prime_divisors(N, Divisors) :- 
	integer(N), 
	!, 
	divisors(N, 2, Divisors). 

num(1, []).
num(N, [V | T]) :- 
	prime(V), 
	num(N1, T),
	N is N1 * V.

divisors(N, N, [N]) :- !.
divisors(1, _, []) :- !.
divisors(N, D, [N]) :- 
	D1 is D * D, 
	D1 > N, !.

divisors(N, D, [H | T]) :-
	(divby(N, D), H is D, N1 is N / H, divisors(N1, D, T)) ;
	(not divby(N, D), D1 is D + 1, divisors(N, D1, [H | T])).

init(N) :-
	N1 is N + 1,
	initPrimes(2, N1, 1).

nth_prime(N, P) :-
	nth_table(P, N).

initPrimes(C, N, D) :-
	C < N,
	prime(C),
	!,
	assert(nth_table(C, D)),
	C1 is C + 1,
	D1 is D + 1, 
	initPrimes(C1, N, D1).

initPrimes(C, N, D) :-
	C < N,
	not prime(C),
	!,
	C1 is C + 1, 
	initPrimes(C1, N, D).

initPrimes(C, N, D) :-
	(C > N ; C = N).
