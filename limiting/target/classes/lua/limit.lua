--print("首先获取到传进来的 key 以及 限流的 count 和时间 time。")
local key = KEYS[1]
local count = tonumber(ARGV[1])
local time = tonumber(ARGV[2])
--print("通过 get 获取到这个 key 对应的值，这个值就是当前时间窗内这个接口可以访问多少次。")
local current = redis.call('get', key)
--print("如果拿到的结果是一个数字，并且这个数字还大于 count，那就说明已经超过流量限制了，那么直接返回查询的结果即可。")
if current and tonumber(current) > count then
    return tonumber(current)
end
--print("如果拿到的结果为 nil，说明是第一次访问，此时就给当前 key 自增 1，然后设置一个过期时间。")
current = redis.call('incr', key)
if tonumber(current) == 1 then
    redis.call('expire', key, time)
end
return tonumber(current)