import { Button } from "@/components/ui/button";
import Image from "next/image";
import {
  Card,
  CardHeader,
  CardTitle,
  CardDescription,
  CardContent,
  CardFooter,
} from "@/components/ui/card";
import { Field, FieldDescription, FieldLabel } from "@/components/ui/field";
import {
  InputOTP,
  InputOTPGroup,
  InputOTPSeparator,
  InputOTPSlot,
} from "@/components/ui/input-otp";
import { RefreshCwIcon } from "lucide-react";
import { useState } from "react";

interface VerificationProps {
  email: string;
  handleSuccess: () => void;
}

export function VerificationCodeInput({
  email,
  handleSuccess,
}: VerificationProps) {
  const [code, setCode] = useState<string>();
  const handleVerificationSubmission = async () => {
    const body = {
      email: email,
      code: code,
    };
    const response = await fetch(`http://localhost:8082/api/auth/verify`, {
      method: "POST",
      body: JSON.stringify(body),
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (response.ok) {
      const data = response.json();
      handleSuccess();
    }
  };

  return (
    <div className="mx-auto max-w-md w-full flex flex-col gap-6 p-2">
      <div className=" flex flex-col border-none items-center justify-center">
        <Image
          className="object-contain"
          src="/logo.png"
          alt="Alien Logo"
          width={48}
          height={48}
          priority
        />
        <div>Please Enter Your One Time Code</div>
        <div className="text-center text-gray-400 flex flex-col">
          {"We've sent you an email with a verification code to this address:"}
          <span className="text-gray-600 font-medium">m@example.com</span>
        </div>
      </div>
      <div>
        <Field>
          <div className="flex items-center justify-end">
            <Button variant="outline" size="xs">
              <RefreshCwIcon />
              Resend Code
            </Button>
          </div>
          <div className="flex justify-center">
            <InputOTP
              value={code}
              onChange={(otp) => setCode(otp)}
              onComplete={(otp: string) => handleVerificationSubmission()}
              maxLength={6}
              id="otp-verification"
              required
            >
              <InputOTPGroup className="gap-2 *:data-[slot=input-otp-slot]:h-12 *:data-[slot=input-otp-slot]:w-11 *:data-[slot=input-otp-slot]:text-xl">
                {Array.from({ length: 6 }).map((_, i) => {
                  return (
                    <InputOTPSlot
                      className="border-2 border-black"
                      key={i}
                      index={i}
                    />
                  );
                })}
              </InputOTPGroup>
            </InputOTP>
          </div>
        </Field>
      </div>
      <div>
        <Field>
          <Button type="submit" className="w-full">
            Verify
          </Button>
        </Field>
      </div>
    </div>
  );
}
