"use client";
import Image from "next/image";
import Link from "next/link";
import { redirect } from "next/navigation";
import { FormEvent, useState } from "react";

interface AuthProps {
  setOpen: (type: string) => void;
  type: "Login" | "Register";
  openVerification?: () => void;
}

export function AuthForm({ setOpen, type, openVerification }: AuthProps) {
  const [username, setUsername] = useState<string>("");
  const [email, setEmail] = useState<string>("");
  const [password, setPassword] = useState<string>("");

  const handleAuth = async (e: FormEvent, authType: string) => {
    e.preventDefault();

    const authVariable = authType.toLowerCase();
    const body =
      authVariable === "register"
        ? {
            username: username,
            email: email,
            password: password,
          }
        : {
            email: email,
            password: password,
          };

    let success = false;
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
    <form onSubmit={(e) => handleAuth(e, type)}>
      <div className="flex flex-col items-center justify-center py-10 gap-10 transition-all duration-500 ease-in-out">
        <div>
          <h3 className="text-4xl font-roboto">
            Welcome{type == "Register" ? "" : " Back"}!
          </h3>
        </div>
        <div className="flex flex-col gap-6">
          {type == "Register" && (
            <input
              className="p-3 border-gray-200 border-2 w-80"
              type="username"
              placeholder="Enter Your Username"
              name="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            ></input>
          )}
          <input
            className="p-3 border-gray-200 border-2 w-80"
            type="text"
            placeholder="Email Address"
            name="username"
            value={email}
            required
            onChange={(e) => setEmail(e.target.value)}
          ></input>

          <div className="flex flex-col gap-3">
            <input
              className="p-3 border-gray-200 border-2 w-80"
              type="password"
              placeholder="Password"
              name="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            ></input>
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
          </div>

          {type === "Register" && (
            <input
              className="p-3 border-gray-200 border-2 w-80"
              type="password"
              placeholder="Confirm Password"
              name="confirmPassword"
              required
            ></input>
          )}
        </div>
        <div className="flex flex-col gap-2">
          <button className="p-3 w-80 border bg-black text-white">
            {type === "Register" ? "Register" : "Sign In"}
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
                Already have an account? Sign In Now
              </button>
            ) : (
              <button onClick={() => setOpen("Login")}>
                Don't have an account? Sign Up Now
              </button>
            )}
          </p>
        </div>
      </div>
    </form>
  );
}
