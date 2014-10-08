<?php




function db_escape($data) {
	return str_replace("'", "\'", $data);
}


// Employees
$data = file_get_contents("mitarbeiter.csv");
$data = explode("\n", $data);
foreach ($data as $k) {
	$v = explode(";", db_escape($k));
	if (count($v) < 3) continue;
	echo "INSERT INTO `Employee` (id, familyName, firstName) VALUES ({$v[0]}, '{$v[2]}', '{$v[1]}');\n";
}

// Function
$data = file_get_contents("function.csv");
$data = explode("\n", $data);
foreach ($data as $k) {
	$v = explode(";", db_escape($k));
	if (count($v) < 2) continue;
	echo "INSERT INTO `Function` (id, name) VALUES ({$v[0]}, '{$v[1]}');\n";
}


// Employee_Function
$data = file_get_contents("mitarbeiter_function.csv");
$data = explode("\n", $data);
foreach ($data as $k) {
	$v = explode(";", db_escape($k));
	if (count($v) < 3) continue;
	echo "INSERT INTO `Employee_Function` (id, evaluation, id_employee, id_function) VALUES (null, {$v[2]}, {$v[0]}, {$v[1]});\n";
}

// Playtype
$data = file_get_contents("playtype.csv");
$data = explode("\n", $data);
foreach ($data as $k) {
	$v = explode(";", db_escape($k));
	if (count($v) < 2) continue;
	echo "INSERT INTO `PlayType` (id, name) VALUES ({$v[0]}, '{$v[1]}');\n";
}

// Play
$data = file_get_contents("play.csv");
$data = explode("\n", $data);
foreach ($data as $k) {
	$v = explode(";", db_escape($k));
	if (count($v) < 3) continue;
	echo "INSERT INTO `Play` (id, name, playType_id) VALUES ({$v[0]}, '{$v[1]}', {$v[2]});\n";
}

// Process
echo "SET FOREIGN_KEY_CHECKS = 0;\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (1, 'Korrepetitionsprobe', 2);\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (2, 'Ensembleprobe', 3);\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (3, 'Szenische Probe', 4);\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (4, 'Bühnenprobe', 7)\n;";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (5, 'Chor-allein Probe', 7);\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (6, 'Orchester-allein Probe', 7);\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (7, 'Klavierprobe', 8);\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (8, 'Orchesterhauptprobe', 9);\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (9, 'Generalprobe', 10);\n";
echo "INSERT INTO `Process` (id, name, next_id) VALUES (10, 'Premiere', null);\n";
echo "SET FOREIGN_KEY_CHECKS = 1;\n";

// Performancetype
echo "INSERT INTO `PerformanceType` (id, name, processStart_id) VALUES (1, 'Neuinszenierung', 1);\n";
echo "INSERT INTO `PerformanceType` (id, name, processStart_id) VALUES (2, 'Wiederaufnahme', 3);\n";
echo "INSERT INTO `PerformanceType` (id, name, processStart_id) VALUES (3, 'Repertoire', 10);\n";

// Performance
$data = file_get_contents("performance.csv");
$data = explode("\n", $data);
foreach ($data as $k) {
	$v = explode(";", db_escape($k));
	if (count($v) < 4) continue;
	echo "INSERT INTO `Performance` (id, play_id, date, performanceType_id) VALUES ({$v[0]}, {$v[1]}, STR_TO_DATE('{$v[2]}', '%d.%m.%Y'), {$v[3]});\n";
}


// Employee_Performance1-10
for ($i = 1; $i <= 10; $i++) {
	$data = file_get_contents("employee_performance$i.csv");
	$data = explode("\n", $data);
	foreach ($data as $k) {
		$v = explode(";", db_escape($k));
		if (count($v) < 2) continue;
		echo "INSERT INTO `Performance_Employee` (performances_id, employees_id) VALUES ({$v[1]}, {$v[0]});\n";
	}
}

// Rooms
$data = file_get_contents("rooms.csv");
$data = explode("\n", $data);
foreach ($data as $k) {
	$v = explode(";", db_escape($k));
	if (count($v) < 2) continue;
	echo "INSERT INTO `Room` (id, name) VALUES ({$v[0]}, '{$v[1]}');\n";
}
