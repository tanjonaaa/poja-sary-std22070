create table if not exists transformation (
    id text primary key,
    transformation_timestamp timestamp not null default (strftime('%Y-%m-%d %H:%M:%S', 'now'))
);
