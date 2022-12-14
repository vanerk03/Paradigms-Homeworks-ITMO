map_build([V], [V, [], []]) :- !.
map_build([], []) :- !.
map_build(List, [V, L, R]) :-
	split(List, ListLeft, ListRight, V),
	map_build(ListLeft, L),
	map_build(ListRight, R).

map_get([(K1, V1), L, R], K, V) :-
	(K = K1, V = V1) ;
	(K < K1, map_get(L, K, V)) ;
	map_get(R, K, V).
	
split(T, L, R, V) :- 
	length(T, S),
	M is S // 2,
	split(T, M, 0, L, R, V).

split([H | T], M, M, [], T, H) :- !.
split([H | T], M, K, [H | L], R, V) :-
	K1 is K + 1,
	split(T, M, K1, L, R, V).

map_replace([], K, V, []) :- !. 
map_replace([(K, V), L, R], K, V1, [(K, V1), L, R]) :- !.

map_replace([(K1, V1), L, R], K, V, [(K1, V1), L, Result]) :-
	K > K1, map_replace(R, K, V, Result), !.   

map_replace([(K1, V1), L, R], K, V, [(K1, V1), Result, R]) :-
	K < K1, map_replace(L, K, V, Result), !.
	
