INSERT INTO USER (id, username, admin, locked, enabled, password) VALUES (1, 'admin', TRUE, FALSE, TRUE, '$2a$10$KJW5kPDGlT2IqdkGL9mq1.Ht2s.db7JGz/BFNS4izFS1EN6ZNesCW');
INSERT INTO USER (id, username, admin, locked, enabled, password) VALUES (2, 'user1', FALSE, FALSE, TRUE, '$2a$10$dfSkfB5JSPjPXsBGWvXyHuctwxPOIMZflp6K8SXXRIZs0qsv.3tky');
INSERT INTO USER (id, username, admin, locked, enabled, password) VALUES (3, 'user2', FALSE, FALSE, TRUE, '$2a$10$koujAbiaTBLDhUw44oLPBO1lMwLvegWS8bQZY9byUeXywE4920fn2');

INSERT INTO BLOG_POST (id, author_id, created, content) VALUES (1, 2, 1504613472, 'Test 1');

INSERT INTO COMMENT (id, blog_post_id, author_id, created, content) VALUES (1, 1, 3, 1504613472, 'Test Comment 1');
INSERT INTO COMMENT (id, blog_post_id, author_id, created, content) VALUES (2, 1, 2, 1504613472, 'Test Comment 2');

INSERT INTO BLOG_POST (id, author_id, created, content) VALUES (2, 3, 1504613472, 'Test 2');