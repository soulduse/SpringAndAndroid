# 안드로이드에 대한 요구명세
============================

### Reply
-------------

- Insert
```
- Parameter Request List
info_idx  //  INFO TABLE로 부터 받은 info_idx
content   //  댓글 내용
email     //  이메일 
```

- Select
```
- Parameter Request List
info_idx  //  INFO TABLE로 부터 받은 info_idx

- Parameter Response List
CONTENT   // 댓글 내용
EMAIL     // 이메일
DATE      // 댓글 등록일
```

- Update
```
- Parameter Request List
content   // 수정할 댓글 내용
email     // 댓글 작성자 본인확인을 위한 값

- Parameter Response List
CONTENT   // 댓글 내용
EMAIL     // 이메일
DATE      // 댓글 등록일
```

- Delete
```
- Parameter Request List
email     // 댓글 작성자 본인확인을 위한 값

- Parameter Response List
CONTENT   // 댓글 내용
EMAIL     // 이메일
DATE      // 댓글 등록일
```
