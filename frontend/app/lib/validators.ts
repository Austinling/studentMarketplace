export function validateUsername(username: string) {
  const usernameRegex = /^.{5,}$/;

  return usernameRegex.test(username);
}

export function validateEmail(email: string) {
  //Checks if an email contains .ac.uk
  const emailRegex = /^[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\.)+ac\.uk$/;

  return emailRegex.test(email);
}

export function validatePassword(password: string) {
  // Checks if a password contains at least one number,uppercase letter, symbol, and a minimum of 8 characters.
  const passwordRegex =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  return passwordRegex.test(password);
}

export function confirmPasswordValidation(
  firstPassword: string,
  secondPassword: string,
) {
  return firstPassword === secondPassword;
}
