INSERT INTO `Roles` (`ROLE_ID`, `role`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `Roles` (`ROLE_ID`, `role`) VALUES ('2', 'ROLE_STUDENT');
INSERT INTO `Roles` (`ROLE_ID`, `role`) VALUES ('3', 'ROLE_TEACHER');

INSERT INTO `People` (`PERSON_ID`, `birthDate`, `cpf`, `email`, `idNumber`, `name`, `phoneNumber`) VALUES (NULL, '2016-02-01 00:00:00', '00000000000', 'a@a.com', '0000000', 'Admin do Universo', '6200000000');

INSERT INTO `Users` (`USER_ID`, `active`, `password`, `userName`, `user_PERSON_ID`) VALUES (NULL, b'1', '$2a$10$bIWTTc4nqZOqG9TuTWsry.zKnPWdhxDTFvnwrevHfUk9tK0MJvR6W', 'admin', '1');

INSERT INTO `User_Roles` (`ROLE_ID`, `USER_ID`) VALUES ('1', '1');