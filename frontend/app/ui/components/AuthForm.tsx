"use client";
import Image from "next/image";
import Link from "next/link";
import { redirect } from "next/navigation";
import { FormEvent, useState } from "react";
import styles from "../modules/home.module.css";
import {
  confirmPasswordValidation,
  validateEmail,
  validatePassword,
  validateUsername,
} from "@/app/lib/validators";
import clsx from "clsx";
import { ShieldAlert } from "lucide-react";
import { AnimatePresence, motion } from "framer-motion";
import { FormDetails } from "./TopNavBar";

interface AuthProps {
  formDetails: FormDetails;
  setFormDetails: (formDetails: FormDetails) => void;
  setOpen: (type: string) => void;
  type: "Login" | "Register";
  openVerification?: () => void;
}

interface FormClicked {
  username: boolean;
  email: boolean;
  password: boolean;
  confirmPassword: boolean;
}

const errorMessages: Record<string, string> = {
  usernameError: "Username must contain at least 5 characters",
  emailError: "You must enter a valid .ac.uk email",
  passwordError:
    "Passwords must contain at least one uppercase letter, one number, one symbol, and at least 8 characters.",
  differentPasswordError: "Passwords don't match",
};

export function AuthForm({
  formDetails,
  setFormDetails,
  setOpen,
  type,
  openVerification,
}: AuthProps) {
  const [hasClicked, setClicked] = useState<FormClicked>({
    username: false,
    email: false,
    password: false,
    confirmPassword: false,
  });
  const [showFormError, setShowFormError] = useState<boolean>(false);
  const [isLoading, setLoading] = useState<boolean>(false);

  const emailError = hasClicked.email && !validateEmail(formDetails.email);
  const usernameError =
    hasClicked.username && !validateUsername(formDetails.username);
  const passwordError =
    hasClicked.password && !validatePassword(formDetails.password);
  const differentPasswordError =
    hasClicked.confirmPassword &&
    !confirmPasswordValidation(
      formDetails.password,
      formDetails.confirmPassword,
    );

  const finalError =
    emailError || usernameError || passwordError || differentPasswordError;

  const handleFormValue = (e: React.ChangeEvent<HTMLInputElement>): void => {
    setFormDetails({
      ...formDetails,
      [e.target.name]: e.target.value,
    });
  };

  const handleClicked = (e: React.ChangeEvent<HTMLInputElement>): void => {
    setClicked((prev) => ({ ...prev, [e.target.name]: true }));
  };

  const handleRedOutline = (hasError: boolean) => {
    return clsx(
      "p-3 border-2 w-80 outline-none transition-colors text-sm rounded",
      {
        "border-red-600 focus:border-red-600": hasError,
        "border-gray-200 focus:border-gray-200": !hasError,
      },
    );
  };

  const handleSubmissionError = async () => {
    setShowFormError(true);
    await new Promise((resolve) => setTimeout(resolve, 2000));
    setShowFormError(false);
  };

  const handleAuth = async (e: FormEvent, authType: string) => {
    e.preventDefault();
    if (finalError) {
      handleSubmissionError();
      return;
    }

    const authVariable = authType.toLowerCase();
    const body =
      authVariable === "register"
        ? {
            username: formDetails.username,
            email: formDetails.email,
            password: formDetails.password,
          }
        : {
            email: formDetails.email,
            password: formDetails.password,
          };

    let success = false;
    setLoading(true);
    try {
      const response = await fetch(
        `http://localhost:8082/api/auth/${authVariable}`,
        {
          method: "POST",
          body: JSON.stringify(body),
          headers: {
            "Content-Type": "application/json",
          },
        },
      );

      if (response.ok) {
        const data = await response.json();

        success = true;
      } else {
        console.log("Failure to log in");
      }
    } catch (error) {
      console.error("Error is ", error);
    }

    if (success && authVariable === "register" && openVerification) {
      console.log("This works.");
      openVerification();
    }
  };

  return (
    <form className="relative" onSubmit={(e) => handleAuth(e, type)} noValidate>
      {showFormError && (
        <AnimatePresence>
          <motion.div
            initial={{ opacity: 0, y: -20 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: 20 }}
            transition={{ ease: "easeInOut", duration: 0.3 }}
            className="absolute flex items-center justify-center gap-5 top-0 bg-red-600 p-5"
          >
            <ShieldAlert className="text-white" />
            <span className="text-white  text-md">
              Please fix the errors before submitting
            </span>
          </motion.div>
        </AnimatePresence>
      )}

      <div className="flex flex-col items-center justify-center py-10 gap-10 transition-all duration-500 ease-in-out">
        <div>
          <h3 className="text-4xl font-roboto">
            Welcome{type == "Register" ? "" : " Back"}!
          </h3>
        </div>
        <div className="flex flex-col gap-6">
          {type == "Register" && (
            <div className="flex flex-col items-center gap-1">
              <input
                className={handleRedOutline(usernameError)}
                type="text"
                placeholder="Enter Your Username"
                name="username"
                value={formDetails.username}
                onChange={(e) => handleFormValue(e)}
                onBlur={(e) => handleClicked(e)}
                required
              ></input>
              {usernameError && (
                <span className="text-sm text-red-700">
                  {errorMessages.usernameError}
                </span>
              )}
            </div>
          )}
          <div className="flex flex-col text-center items-center gap-1">
            <input
              className={handleRedOutline(emailError)}
              type="text"
              placeholder="Email Address"
              name="email"
              value={formDetails.email}
              required
              onChange={(e) => handleFormValue(e)}
              onBlur={(e) => handleClicked(e)}
            ></input>
            {emailError && (
              <span className="text-sm text-red-700">
                {errorMessages.emailError}
              </span>
            )}
          </div>

          <div className="flex flex-col text-center items-center gap-1">
            <input
              className={handleRedOutline(passwordError)}
              type="password"
              placeholder="Password"
              name="password"
              value={formDetails.password}
              onChange={(e) => handleFormValue(e)}
              onBlur={(e) => handleClicked(e)}
              required
            ></input>
            {passwordError && (
              <span className="text-sm text-red-700">
                {errorMessages.passwordError}
              </span>
            )}
          </div>

          {type == "Login" && (
            <div className="flex items-center justify-between">
              <div className="flex gap-2">
                <input type="checkbox" />
                <p>Remember for 30 days</p>
              </div>

              <p className="text-blue-400 underline text-right">
                <Link href="/login">Forgot password?</Link>
              </p>
            </div>
          )}

          {type === "Register" && (
            <div className="flex flex-col text-center items-center gap-1">
              <input
                className={handleRedOutline(differentPasswordError)}
                type="password"
                placeholder="Confirm Password"
                name="confirmPassword"
                value={formDetails.confirmPassword}
                required
                onChange={(e) => handleFormValue(e)}
                onBlur={(e) => handleClicked(e)}
              ></input>
              {differentPasswordError && (
                <span className="text-sm text-red-700">
                  {errorMessages.differentPasswordError}
                </span>
              )}
            </div>
          )}
        </div>
        <div className="flex flex-col gap-2">
          <button
            disabled={isLoading || finalError}
            className="p-3 h-14 w-80 flex items-center justify-center border bg-black text-white"
          >
            {isLoading ? (
              <div className={styles.loader}></div>
            ) : type === "Register" ? (
              "Register"
            ) : (
              "Sign In"
            )}
          </button>
          <button className="p-1 w-80 flex items-center justify-center gap-2 border-gray-200 border-2">
            <Image
              className=""
              src="/google.svg"
              alt="Google Logo"
              width={40}
              height={40}
              priority
            />
            Sign In With Google
          </button>

          <p className="text-blue-400 underline text-center">
            {type == "Register" ? (
              <button onClick={() => setOpen("Register")}>
                {"Already have an account? Sign In Now"}
              </button>
            ) : (
              <button onClick={() => setOpen("Login")}>
                {"Don't have an account? Sign Up Now"}
              </button>
            )}
          </p>
        </div>
      </div>
    </form>
  );
}
