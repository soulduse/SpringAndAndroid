# 안드로이드에 대한 요구명세
============================

### Reply
-------------

- Insert
```
- 보낼 Parameter
info_idx  //  INFO TABLE로 부터 받은 info_idx
content   //  댓글 내용
email     //  이메일 
```

- Select
```
- 보낼 Parameter
info_idx  //  INFO TABLE로 부터 받은 info_idx

- 받을 Parameter
CONTENT   // 댓글 내용
EMAIL     // 이메일
DATE      // 댓글 등록일
```

- Update
```
- 보낼 Parameter
content   // 수정할 댓글 내용
email     // 댓글 작성자 본인확인을 위한 값
```

- Delete
```
- 보낼 Parameter
email     // 댓글 작성자 본인확인을 위한 값
```
