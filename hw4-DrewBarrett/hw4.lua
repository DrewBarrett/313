-- 2a
-- Exponents
function pow(a,b)
    if b == 0 then
        return 0
    end
    local c = a
    for x = 1,b-1,1 do
        c = c * a
    end
    return c
end

--2b
--Array summation
function sigma(array)
    local sum = 0
    for _,value in pairs(array) do
        sum = sum + value
    end
    return sum
end

--3a
--Longest string
function longestString(...)
    local function longer(str1, str2)
        return (#str1 > #str2) and str1 or str2
    end
    local longest = arg[1]
    local compare = 2
    while compare < 5 do
        if arg[compare] == nil then
            break
        end
        longest = longer(longest, arg[compare])
        compare = compare + 1
    end
    return longest
end

--3b
--Quadratic Formula
function quadratic(a,b,c)
    sqrt = math.sqrt(pow(b,2) - 4*a*c)
    x1 = (-b + sqrt)/(2*a)
    x2 = (-b - sqrt)/(2*a)
    return x1, x2
end

--4a
--read in the file

function fromTSV(s, ending)
    --s = s .. '\n'        -- ending tab
    local t = {}        -- table to collect fields
    local fieldstart = 1
    repeat
        local nexti = string.find(s, ending, fieldstart)
        table.insert(t, string.sub(s, fieldstart, nexti-1))
        fieldstart = nexti + 1
    until fieldstart > string.len(s)
    return t
end
words = io.open("turing.tsv")
all = words:read("*all")
t = fromTSV(all, '\n')
final = {}
for _, s in ipairs(t) do 
    s = s .. '\t'
    inner = fromTSV(s,'\t')
    --for _,v in ipairs(new) do
    --    print(v)
    --end
    table.insert(final, inner)
end

--4b
--sort table by area of research

function sortTableByCol(inTable, col)
    table.sort(inTable,
        function (a,b) return a[col] < b[col] end)
end

sortTableByCol(final, 4)

print("Table sorted by area of research: ")

function printTableInTable(inTable)
    for i, row in ipairs(inTable) do
        str = ""
        for _, col in ipairs(row) do
            str = str .. col .. "\t"
        end
        print(str)
    end
end

printTableInTable(final)


--4c
--sort table by institution of winner
print("Table sorted by institution of winner:")
sortTableByCol(final, 3)
printTableInTable(final)
