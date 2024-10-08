-- 태그 전체 삽입
INSERT INTO time_tables (time_tables_id, code, place) VALUES
                                                          (1, 'T10:00', '창업보육실1'), (2, 'T10:00', '창업보육실3'),
                                                          (3, 'T10:30', '창업보육실1'), (4, 'T10:30', '창업보육실3'),
                                                          (5, 'T11:00', '창업보육실1'), (6, 'T11:00', '창업보육실3'),
                                                          (7, 'T11:30', '창업보육실1'), (8, 'T11:30', '창업보육실3'),
                                                          (9, 'T12:00', '창업보육실1'), (10, 'T12:00', '창업보육실3'),
                                                          (11, 'T12:30', '창업보육실1'), (12, 'T12:30', '창업보육실3'),
                                                          (13, 'T13:00', '창업보육실2'), (14, 'T13:00', '창업보육실3'),
                                                          (15, 'T13:30', '창업보육실2'), (16, 'T13:30', '창업보육실3'),
                                                          (17, 'T14:00', '창업보육실2'), (18, 'T14:00', '창업보육실3'),
                                                          (19, 'T14:30', '창업보육실2'), (20, 'T14:30', '창업보육실3'),
                                                          (21, 'T15:00', '창업보육실2'), (22, 'T15:00', '창업보육실3'),
                                                          (23, 'T15:30', '창업보육실2'), (24, 'T15:30', '창업보육실3'),
                                                          (25, 'T16:00', '창업보육실2'), (26, 'T16:00', '창업보육실3'),
                                                          (27, 'T16:30', '창업보육실2'), (28, 'T16:30', '창업보육실3'),
                                                          (29, 'T17:00', '창업보육실2'), (30, 'T17:00', '창업보육실3'),
                                                          (31, 'T17:30', '창업보육실2'), (32, 'T17:30', '창업보육실3'),
                                                          (33, 'T18:00', '창업보육실2'), (34, 'T18:00', '창업보육실3'),
                                                          (35, 'T18:30', '창업보육실2'), (36, 'T18:30', '창업보육실3'),
                                                          (37, 'T19:00', '창업보육실2'), (38, 'T19:00', '창업보육실3'),
                                                          (39, 'T19:30', '창업보육실2'), (40, 'T19:30', '창업보육실3'),
                                                          (41, 'T20:00', '창업보육실2'), (42, 'T20:00', '창업보육실3'),
                                                          (43, 'T20:30', '창업보육실2'), (44, 'T20:30', '창업보육실3'),
                                                          (45, 'S10:00', '창업보육실2'), (46, 'S10:00', '창업보육실3'),
                                                          (47, 'S10:30', '창업보육실2'), (48, 'S10:30', '창업보육실3'),
                                                          (49, 'S11:00', '창업보육실2'), (50, 'S11:00', '창업보육실3'),
                                                          (51, 'S11:30', '창업보육실2'), (52, 'S11:30', '창업보육실3'),
                                                          (53, 'S12:00', '창업보육실2'), (54, 'S12:00', '창업보육실3'),
                                                          (55, 'S12:30', '창업보육실2'), (56, 'S12:30', '창업보육실3'),
                                                          (57, 'S13:00', '창업보육실2'), (58, 'S13:00', '창업보육실3'),
                                                          (59, 'S13:30', '창업보육실2'), (60, 'S13:30', '창업보육실3'),
                                                          (61, 'S14:00', '창업보육실2'), (62, 'S14:00', '창업보육실3'),
                                                          (63, 'S14:30', '창업보육실2'), (64, 'S14:30', '창업보육실3'),
                                                          (65, 'S15:00', '창업보육실2'), (66, 'S15:00', '창업보육실3'),
                                                          (67, 'S15:30', '창업보육실2'), (68, 'S15:30', '창업보육실3'),
                                                          (69, 'S16:00', '창업보육실2'), (70, 'S16:00', '창업보육실3'),
                                                          (71, 'S16:30', '창업보육실2'), (72, 'S16:30', '창업보육실3'),
                                                          (73, 'S17:00', '창업보육실2'), (74, 'S17:00', '창업보육실3'),
                                                          (75, 'S17:30', '창업보육실2'), (76, 'S17:30', '창업보육실3')
ON DUPLICATE KEY UPDATE time_tables_id = time_tables_id;