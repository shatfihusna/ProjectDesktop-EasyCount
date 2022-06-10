-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Jun 2021 pada 14.09
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_easycount`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama_admin` varchar(50) NOT NULL,
  `company_admin` varchar(50) NOT NULL,
  `nohp_admin` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`, `nama_admin`, `company_admin`, `nohp_admin`) VALUES
(1, 'admin', 'admin', 'admin', 'admin', 812126212),
(2, 'shatfi@gmail.com', '123456', 'shatfi', 'Spassbox', 813633124),
(3, 'raven', '12345', 'Raven', 'spass box', 812821);

-- --------------------------------------------------------

--
-- Struktur dari tabel `bahan`
--

CREATE TABLE `bahan` (
  `id_bahan` int(11) NOT NULL,
  `nama_bahan` varchar(50) NOT NULL,
  `jumlah_bahan` int(10) NOT NULL,
  `satuan_bahan` varchar(10) NOT NULL,
  `harga_bahan` int(15) NOT NULL,
  `tanggal_masuk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `bahan`
--

INSERT INTO `bahan` (`id_bahan`, `nama_bahan`, `jumlah_bahan`, `satuan_bahan`, `harga_bahan`, `tanggal_masuk`) VALUES
(1, 'Gula ', 16, 'Kg', 16000, '21-02-2021'),
(2, 'Bawang Merah', 15, 'Kg', 10000, '30-05-2021'),
(3, 'Bawang Putih', 50, 'Kg', 25000, '12-05-2021'),
(4, 'Garam', 100, 'kg', 1000000, '2021-06-17'),
(5, 'royko', 0, 'pcs', 500, '2021-06-17');

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `kode_customer` int(11) NOT NULL,
  `kode_menu` int(11) NOT NULL,
  `id_pemesanan` int(11) NOT NULL,
  `id_kasir` int(11) NOT NULL,
  `banyak_pesan` int(15) NOT NULL,
  `jumlah` int(15) NOT NULL,
  `uang_bayar` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `hitung`
--

CREATE TABLE `hitung` (
  `kode_menu` int(50) NOT NULL,
  `nama_menu` int(50) NOT NULL,
  `harga_menu` int(50) NOT NULL,
  `jumlah` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kasir`
--

CREATE TABLE `kasir` (
  `id_kasir` int(11) NOT NULL,
  `nama_kasir` varchar(50) NOT NULL,
  `company_kasir` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nohp_kasir` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kasir`
--

INSERT INTO `kasir` (`id_kasir`, `nama_kasir`, `company_kasir`, `username`, `password`, `nohp_kasir`) VALUES
(1, 'shatfi', 'sdsd', 'sadsf', '123456', '123456'),
(2, 'raven', '12345', 'Raven', 'Spass box', '0812526');

-- --------------------------------------------------------

--
-- Struktur dari tabel `menu`
--

CREATE TABLE `menu` (
  `kode_menu` int(11) NOT NULL,
  `nama_menu` varchar(30) NOT NULL,
  `jenis` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `harga_menu` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `menu`
--

INSERT INTO `menu` (`kode_menu`, `nama_menu`, `jenis`, `harga_menu`) VALUES
(1, 'Nasi Goreng', 'Makanan', 15000),
(2, 'Jus Jeruk', 'Minuman', 10000),
(3, 'Mie Goreng', 'Makanan', 15000),
(5, 'Jus Mangga', 'Minuman', 15000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemakaian`
--

CREATE TABLE `pemakaian` (
  `kode_menu` int(11) NOT NULL,
  `id_bahan` int(11) NOT NULL,
  `nama_bahan` varchar(50) NOT NULL,
  `jumlah_pakai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pemakaian`
--

INSERT INTO `pemakaian` (`kode_menu`, `id_bahan`, `nama_bahan`, `jumlah_pakai`) VALUES
(1, 2, 'Bawang Merah', 1),
(3, 3, 'Bawang Putih', 1),
(1, 2, 'Bawang Merah', 2),
(2, 1, 'Gula ', 5),
(1, 2, 'Bawang Merah', 1),
(2, 2, 'Bawang Merah', 1),
(2, 1, 'Gula ', 6),
(3, 2, 'Bawang Merah', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_pemesanan` int(11) NOT NULL,
  `kode_transaksi` int(11) NOT NULL,
  `tanggal_pesan` varchar(50) NOT NULL,
  `kode_menu` int(11) NOT NULL,
  `nama_menu` varchar(50) NOT NULL,
  `harga_menu` int(11) NOT NULL,
  `jumlah_pesan` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pemesanan`
--

INSERT INTO `pemesanan` (`id_pemesanan`, `kode_transaksi`, `tanggal_pesan`, `kode_menu`, `nama_menu`, `harga_menu`, `jumlah_pesan`) VALUES
(1, 0, '12', 1, 'Nasi Goreng', 15000, 1),
(2, 0, '12', 3, 'Mie Goreng', 15000, 1),
(3, 0, '766', 1, 'Nasi Goreng', 15000, 3),
(15, 0, '56757', 5, 'Jus Mangga', 15000, 2),
(16, 1, '2021-06-17', 1, 'Nasi Goreng', 15000, 1),
(17, 2, '2021-06-17', 1, 'Nasi Goreng', 15000, 1),
(18, 3, '2021-06-17', 1, 'Nasi Goreng', 15000, 1),
(19, 4, '2021-06-17', 1, 'Nasi Goreng', 15000, 1),
(20, 5, '2021-06-17', 5, 'Jus Mangga', 15000, 1),
(21, 6, '2021-06-17', 3, 'Mie Goreng', 15000, 1),
(22, 7, '2021-06-17', 2, 'Jus Jeruk', 10000, 1),
(50, 8, '2021-06-17', 5, 'Jus Mangga', 15000, 1),
(51, 9, '2021-06-17', 2, 'Jus Jeruk', 10000, 1),
(52, 10, '2021-06-17', 5, 'Jus Mangga', 15000, 2),
(53, 11, '2021-06-17', 1, 'Nasi Goreng', 15000, 1),
(54, 12, '2021-06-17', 1, 'Nasi Goreng', 15000, 3),
(55, 13, '2021-06-17', 1, 'Nasi Goreng', 15000, 3),
(56, 0, '2021-06-17', 1, 'Nasi Goreng', 15000, 3),
(57, 0, '2021-06-17', 2, 'Jus Jeruk', 10000, 8),
(58, 14, '2021-06-17', 1, 'Nasi Goreng', 15000, 9),
(59, 15, '2021-06-17', 5, 'Jus Mangga', 15000, 2),
(60, 15, '2021-06-17', 2, 'Jus Jeruk', 10000, 4),
(61, 15, '2021-06-17', 1, 'Nasi Goreng', 15000, 9),
(62, 16, '2021-06-17', 1, 'Nasi Goreng', 15000, 2),
(63, 16, '2021-06-17', 2, 'Jus Jeruk', 10000, 5),
(64, 18, '2021-06-17', 2, 'Jus Jeruk', 10000, 5),
(65, 18, '2021-06-17', 5, 'Jus Mangga', 15000, 4),
(66, 18, '2021-06-17', 3, 'Mie Goreng', 15000, 3),
(67, 19, '2021-06-17', 5, 'Jus Mangga', 15000, 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_pemesanan` int(11) NOT NULL,
  `totalbelanja` int(11) NOT NULL,
  `uangbayar` int(11) NOT NULL,
  `uangkembali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_pemesanan`, `totalbelanja`, `uangbayar`, `uangkembali`) VALUES
(16, 63, 30000, 50000, 20000),
(18, 67, 155000, 200000, 45000),
(19, 68, 45000, 50000, 5000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `bahan`
--
ALTER TABLE `bahan`
  ADD PRIMARY KEY (`id_bahan`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`kode_customer`),
  ADD KEY `kodemenu` (`kode_menu`),
  ADD KEY `id_pemesanan` (`id_pemesanan`),
  ADD KEY `id_kasir` (`id_kasir`);

--
-- Indeks untuk tabel `hitung`
--
ALTER TABLE `hitung`
  ADD KEY `hitung` (`kode_menu`);

--
-- Indeks untuk tabel `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`id_kasir`);

--
-- Indeks untuk tabel `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`kode_menu`);

--
-- Indeks untuk tabel `pemakaian`
--
ALTER TABLE `pemakaian`
  ADD KEY `id_bahan` (`id_bahan`),
  ADD KEY `kode_menu` (`kode_menu`);

--
-- Indeks untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_pemesanan`),
  ADD KEY `kode` (`kode_menu`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD UNIQUE KEY `id_pemesanan` (`id_pemesanan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `bahan`
--
ALTER TABLE `bahan`
  MODIFY `id_bahan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `kode_customer` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `kasir`
--
ALTER TABLE `kasir`
  MODIFY `id_kasir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `menu`
--
ALTER TABLE `menu`
  MODIFY `kode_menu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `id_pemesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `id_kasir` FOREIGN KEY (`id_kasir`) REFERENCES `kasir` (`id_kasir`),
  ADD CONSTRAINT `id_pemesanan` FOREIGN KEY (`id_pemesanan`) REFERENCES `pemesanan` (`id_pemesanan`),
  ADD CONSTRAINT `kodemenu` FOREIGN KEY (`kode_menu`) REFERENCES `menu` (`kode_menu`);

--
-- Ketidakleluasaan untuk tabel `hitung`
--
ALTER TABLE `hitung`
  ADD CONSTRAINT `hitung` FOREIGN KEY (`kode_menu`) REFERENCES `menu` (`kode_menu`);

--
-- Ketidakleluasaan untuk tabel `pemakaian`
--
ALTER TABLE `pemakaian`
  ADD CONSTRAINT `id_bahan` FOREIGN KEY (`id_bahan`) REFERENCES `bahan` (`id_bahan`),
  ADD CONSTRAINT `kode_menu` FOREIGN KEY (`kode_menu`) REFERENCES `menu` (`kode_menu`);

--
-- Ketidakleluasaan untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `kode` FOREIGN KEY (`kode_menu`) REFERENCES `menu` (`kode_menu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
