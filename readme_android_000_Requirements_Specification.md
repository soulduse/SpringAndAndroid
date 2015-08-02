# 안드로이드에 대한 요구명세
============================

### Reply
-------------
- 필수 SEND Parameter
1. info_idx
2. dbType=[select,insert,update,delete]

- Insert
```
- SEND Parameter
info_idx  //  INFO TABLE로 부터 받은 info_idx
content   //  댓글 내용
email     //  이메일 
```

- Select
```
- SEND Parameter
info_idx  //  INFO TABLE로 부터 받은 info_idx

- GET Values
CONTENT   // 댓글 내용
EMAIL     // 이메일
DATE      // 댓글 등록일
```

- Update
```
- SEND Parameter
content   // 수정할 댓글 내용
email     // 댓글 작성자 본인확인을 위한 값
```

- Delete
```
- SEND Parameter
email     // 댓글 작성자 본인확인을 위한 값
```
