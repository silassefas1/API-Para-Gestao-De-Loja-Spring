-- Renomeiando a tabela 'user' para 'user_account'
ALTER TABLE user RENAME TO user;

-- Adicionando a coluna 'password' na nova tabela
ALTER TABLE user_account
ADD COLUMN password VARCHAR(255);