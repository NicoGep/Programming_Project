-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 03. Nov 2020 um 19:58
-- Server-Version: 10.4.14-MariaDB
-- PHP-Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `wanderoo`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `groups`
--

CREATE TABLE `groups` (
  `groupid` int(11) NOT NULL,
  `groupname` varchar(50) NOT NULL,
  `groupniveau` varchar(30) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `groups`
--

INSERT INTO `groups` (`groupid`, `groupname`, `groupniveau`) VALUES
(1, 'TestGruppe1', '1'),
(2, 'TestGruppe2', '1'),
(3, 'TestGruppe3', '1');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `usercredentials`
--

CREATE TABLE `usercredentials` (
  `userid` int(11) NOT NULL,
  `userpassword` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `usercredentials`
--

INSERT INTO `usercredentials` (`userid`, `userpassword`) VALUES
(1, 3433489);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `useremail` varchar(50) NOT NULL,
  `userprofilepic` varchar(100) DEFAULT NULL,
  `userniveau` varchar(30) NOT NULL DEFAULT '1',
  `userheightdifference` int(11) NOT NULL DEFAULT 100,
  `userroutelength` int(11) NOT NULL DEFAULT 5
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `users`
--

INSERT INTO `users` (`userid`, `username`, `useremail`, `userprofilepic`, `userniveau`, `userheightdifference`, `userroutelength`) VALUES
(1, 'TestBenutzer1', 'test@wanderoo.de', NULL, '1', 100, 5);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `users_groups`
--

CREATE TABLE `users_groups` (
  `userid` int(11) NOT NULL,
  `groupid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `users_groups`
--

INSERT INTO `users_groups` (`userid`, `groupid`) VALUES
(1, 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`groupid`),
  ADD UNIQUE KEY `groupname` (`groupname`);

--
-- Indizes für die Tabelle `usercredentials`
--
ALTER TABLE `usercredentials`
  ADD PRIMARY KEY (`userid`);

--
-- Indizes für die Tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indizes für die Tabelle `users_groups`
--
ALTER TABLE `users_groups`
  ADD PRIMARY KEY (`userid`,`groupid`),
  ADD KEY `groupid` (`groupid`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `groups`
--
ALTER TABLE `groups`
  MODIFY `groupid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `usercredentials`
--
ALTER TABLE `usercredentials`
  ADD CONSTRAINT `usercredentials_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `users_groups`
--
ALTER TABLE `users_groups`
  ADD CONSTRAINT `users_groups_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `users_groups_ibfk_2` FOREIGN KEY (`groupid`) REFERENCES `groups` (`groupid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
