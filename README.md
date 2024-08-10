Aspect Oriented Programming (AOP) là 1 kỹ thuật lập trình dùng để tách logic chương trình thành các phần riêng biệt.
Lợi ích khi sài AOP để có thể implement logic trước hoặc sau 1 method tránh phải đụng vào logic của method đó.

@Before: excute trước function cần chỉ định
@After: excute sau function cần chỉ định
@Around: excute trước và sau function cần chỉ định
Pointcut: đại diện cho condition expression cần excute. Example: "@annotation(TamValidatedRequest)"
Join point: đại diện cho method cần excute. Example createProduct()
