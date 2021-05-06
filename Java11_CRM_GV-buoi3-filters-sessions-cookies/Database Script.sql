create database if not exists `crm`;

use `crm`;

create table if not exists `role` (
	id 			int,
    name 		varchar(50) not null,
    description varchar(500),
    primary key(id)
);

create table if not exists `status` (
	id 			int,
    name	 	varchar(50) not null,
    description varchar(500),
    primary key(id)
);

create table if not exists `user`(
	id 			int,
    email 		varchar(50) not null unique,
    password 	varchar(255) not null,
    fullname 	varchar(255),
    address 	varchar(500),
    phone 		varchar(36),
    role_id 	int not null,
    primary key (id)
);

create table if not exists `task`(
	id			int,
    name		varchar(100) not null,
    description varchar(500),
    start_date	date default(NOW()),
    due_date	date,
    assignee	int,
    project_id	int,
    status_id	int,
    primary key (id)
);

create table if not exists `project`(
	id			int,
    name		varchar(100) not null,
    description varchar(500),
    start_date	date,
    end_date	date,
    create_user_id int,
    primary key (id)
);

create table if not exists `project_user`(
	project_id	int,
    user_id		int,
    join_date	date default(NOW()),
    role_description varchar(500),
    primary key (project_id, user_id)
);

-- add foreign key
alter table `user`
	add constraint `fk_user_role`
		foreign key (role_id) references `role`(id);
        
alter table `task`
	add constraint `fk_task_user`
		foreign key (assignee) references `user`(id);
alter table `task`
	add constraint `fk_task_project`
		foreign key (project_id) references `project`(id);
alter table `task`
	add constraint `fk_task_status`
		foreign key (status_id) references `status`(id);
        
alter table `project`
	add constraint `fk_project_user`
		foreign key (create_user_id) references `user`(id);
        
alter table `project_user`
	add constraint `fk_project_user_to_user`
		foreign key (user_id) references `user`(id);
alter table `project_user`
	add constraint `fk_project_user_to_project`
		foreign key (project_id) references `project`(id);

