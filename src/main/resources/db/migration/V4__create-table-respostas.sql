CREATE TABLE RESPOSTAS (ID INT AUTO_INCREMENT,
                        MENSAGEM VARCHAR(500),
                        ID_TOPICO INT,
                        DATA_CRIACAO DATETIME,
                        ID_AUTOR INT,
                        SOLUCAO BOOLEAN, PRIMARY KEY(ID)

)