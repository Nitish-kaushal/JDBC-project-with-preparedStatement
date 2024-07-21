<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <link rel="stylesheet"href="style.css">
</head>
<body>

<div class="form-container">
    <h2>Registration Form</h2>
    <form>
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName">

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName">

        <label for="nickName">Nick Name</label>
        <input type="text" id="nickName" name="nickName">

        <label for="email">E-mail</label>
        <input type="email" id="email" name="email">

        <label for="password">Password</label>
        <input type="password" id="password" name="password">

        <label for="dob">Date of Birth</label>
        <input type="date" id="dob" name="dob">

        <label>Gender</label>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male" style="display: inline;">Male</label>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female" style="display: inline;">Female</label>
        <input type="radio" id="others" name="gender" value="others">
        <label for="others" style="display: inline;">Others</label>

        <label for="mobile">Mobile</label>
        <input type="text" id="mobile" name="mobile">

        <label for="address">Address</label>
        <textarea id="address" name="address" rows="4" cols="50"></textarea>

        <div class="btn-container">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</div>

</body>
</html>
