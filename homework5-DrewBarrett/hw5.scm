(define shiftLeft
  (lambda (input)
    (if (equal? input '())
        '()
        (append (cdr input) (list(car input)))
    )
  )
)

(define shiftRight
  (lambda (input)
    (if (equal? input '())
      '()
      (append (list(car(reverse input))) (reverse(cdr(reverse input))))
    )
  )
)

(define count
  (lambda (first second)
    (cond
      ((null? second) 0)
      ((equal? first (car second)) (+ 1 (count first (cdr second))))
      (else (count first (cdr second)))
    )
  )
)

(define formatDate
  (lambda (input)
    (map
      (lambda(x)
        (string-append
          (cond
            ( (equal? "January" (car x)) "1")
            ( (equal? "February" (car x)) "2")
            ( (equal? "March" (car x)) "3")
            ( (equal? "April" (car x)) "4")
            ( (equal? "May" (car x)) "5")
            ( (equal? "June" (car x)) "6")
            ( (equal? "July" (car x)) "7")
            ( (equal? "August" (car x)) "8")
            ( (equal? "September" (car x)) "9")
            ( (equal? "October" (car x)) "10")
            ( (equal? "November" (car x)) "11")
            ( (equal? "December" (car x)) "12")
            ( else (car x) )
          )
          "/"
          (number->string (car (cdr x)))
          "/"
          (number->string (car (cddr x)))
        )
      )
      input
    )
  )
)

(define divideAll
  (lambda (input)
    (apply /
      (filter (lambda (x) (<= 1 x)) input)
    )
  )  
)
