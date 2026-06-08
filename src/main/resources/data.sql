-- INSERIR PRODUTOS
INSERT INTO produtos (id, codigo_produto, nome, descricao, preco_unitario) VALUES
('prod-001', 'PROD001', 'Notebook Dell Inspiron', 'Notebook Dell i7, 16GB RAM, 512GB SSD', 4500.00),
('prod-002', 'PROD002', 'Mouse Gamer Logitech', 'Mouse RGB 7 botões, 16000 DPI', 199.90),
('prod-003', 'PROD003', 'Teclado Mecânico HyperX', 'Teclado mecânico switch red, RGB', 350.00),
('prod-004', 'PROD004', 'Monitor Samsung 24"', 'Monitor LED Full HD, 75Hz', 899.00),
('prod-005', 'PROD005', 'SSD Kingston 1TB', 'SSD NVMe, leitura 3500MB/s', 450.00),
('prod-006', 'PROD006', 'Headset Gamer', 'Headset com microfone, 7.1 surround', 280.00),
('prod-007', 'PROD007', 'Cadeira Gamer', 'Cadeira ergonômica com ajuste', 1200.00),
('prod-008', 'PROD008', 'Placa de Vídeo RTX 3060', '12GB GDDR6, Ray Tracing', 2500.00),
('prod-009', 'PROD009', 'Processador Intel i7', '12ª geração, 12 núcleos', 1800.00),
('prod-010', 'PROD010', 'Fonte 650W', 'Fonte modular 80 Plus Gold', 550.00);

-- INSERIR ENDEREÇOS (primeiro, pois cliente referencia)
INSERT INTO enderecos (id, cep, logradouro, complemento, numero, bairro, cidade, uf) VALUES
('end-001', '01001-000', 'Rua Augusta', 'Apto 101', '1000', 'Centro', 'São Paulo', 'SP'),
('end-002', '20020-000', 'Av. Rio Branco', 'Sala 501', '150', 'Centro', 'Rio de Janeiro', 'RJ'),
('end-003', '30130-000', 'Av. Afonso Pena', 'Casa', '2000', 'Centro', 'Belo Horizonte', 'MG'),
('end-004', '80010-000', 'Rua XV de Novembro', NULL, '500', 'Centro', 'Curitiba', 'PR'),
('end-005', '90010-000', 'Av. Borges de Medeiros', 'Sala 10', '1000', 'Centro', 'Porto Alegre', 'RS');


-- INSERIR CLIENTES
INSERT INTO clientes (id, nome, cpf, email, endereco_id) VALUES
('cli-001', 'João Silva', '123.456.789-00', 'joao.silva@email.com', 'end-001'),
('cli-002', 'Maria Santos', '987.654.321-00', 'maria.santos@email.com', 'end-002'),
('cli-003', 'Pedro Oliveira', '456.789.123-00', 'pedro.oliveira@email.com', 'end-003'),
('cli-004', 'Ana Souza', '789.123.456-00', 'ana.souza@email.com', 'end-004'),
('cli-005', 'Carlos Lima', '321.654.987-00', 'carlos.lima@email.com', 'end-005');