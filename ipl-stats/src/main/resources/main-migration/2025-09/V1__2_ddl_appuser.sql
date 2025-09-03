create table if not exists app_user(
    id UUID primary key,
    username varchar(100),
    password varchar(255),
    email varchar(250)
)