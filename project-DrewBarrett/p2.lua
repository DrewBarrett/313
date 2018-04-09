io.input("output.txt")
p1matches = 0
p2matches = 0
p1wins = 0
p2wins = 0
game = 0
turn = 0
currStreak = 0
bestStreak = 0
currGuesses = nil
totGuesses = 0
mostGuesses = 0
leastGuesses = nil
while true do
    line = io.read()
    if line == nil then break end
    --print(line)
    if (string.find( line, 'Game' )) then
        game = game + 1
        turn = 0
        if currGuesses then
            if (leastGuesses == nil or currGuesses < leastGuesses) then
                leastGuesses = currGuesses
            end
            if (currGuesses > mostGuesses) then
                mostGuesses = currGuesses
            end
            totGuesses = totGuesses + currGuesses
        end
        currGuesses = 0
    elseif (string.find( line, 'turn!' )) then
        turn = turn + 1
        if currStreak > bestStreak then
            bestStreak = currStreak
        end
        currStreak = 0
    elseif (string.find( line, 'You matched' )) then
        if turn % 2 == 0 then
            p2matches = p2matches + 1
        else
            p1matches = p1matches + 1
        end
        currGuesses = currGuesses + 1
        currStreak = currStreak + 1
    elseif (string.find (line, 'Not a match')) then
        currGuesses = currGuesses + 1
    elseif (string.find (line, 'Player 2 is the winner!')) then
        p2wins = p2wins + 1
    elseif (string.find( line,'Player 1 is the winner!' )) then
        p1wins = p1wins + 1
    end
    
    --print(game)
end
print('Total number of games played: '..game)
print('Player 1 average matches: '..(p1matches / game))
print('Player 2 average matches: '..(p2matches / game))
print('Longest game: '..mostGuesses..' guesses!')
print('Shortest game: '..leastGuesses..' guesses!')
print('Average number of guesses: '..(totGuesses / game))
print('Longest streak: '..bestStreak)
if p1wins > p2wins then
    print('Player 1 has the most wins!')
else
    print('Player 2 has the most wins!')
end