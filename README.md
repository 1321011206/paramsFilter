# paramsFilter
过滤请求参数中的首尾空格

请求参数（由于用户无意，前端表单提交时，带有空格，然而这是后端Controller不想要的信息）：

```
{
    id: " xxxx ",
    userName: "   Monkey"
    content: "xxxx   "
}
```
经过paramsFilter过滤之后，Controller获取到的参数：
```
{
    id: "xxxx",
    userName: "Monkey"
    content: "xxxx"
}
```
